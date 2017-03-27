package org.java.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class SendMail {

	private static final Logger LOGGER =Logger.getLogger(SendMail.class);

	public boolean getBysendMail(int randomInt, String email) {
		
		String subject="Narayana Engineering College | MCA Department";
		String msg="Use this OTP to reset your password:"+randomInt;
		
		final String username = "emahesh16@gmail.com";
		final String password = "mahiragh1";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		MimeMessage message = new MimeMessage(session);
		try{
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(msg);
			
			Transport.send(message);
			System.out.println("Mail has been sent");
			
		}catch(MessagingException e){
			e.printStackTrace();
			LOGGER.error("Exception while sending mail|Reason-> : "+e);
		}
		return true;
	}
}
