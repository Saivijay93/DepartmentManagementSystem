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

public class SendContactEmail {

	private static final Logger LOGGER =Logger.getLogger(SendContactEmail.class);

	public boolean getBysendMail(String message, String email) {
		
		String subject="Narayana Engineering College | MCA Department";
		String msg="Contacat message from "+email+" , Message is : "+message;
		
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
		
		MimeMessage messages = new MimeMessage(session);
		try{
			messages.setFrom(new InternetAddress(username));
			messages.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			messages.setSubject(subject);
			messages.setText(msg);
			
			Transport.send(messages);
			System.out.println("Mail has been sent");
			
		}catch(MessagingException e){
			e.printStackTrace();
			LOGGER.error("Exception while sending mail|Reason-> : "+e);
		}
		return true;
	}
}
