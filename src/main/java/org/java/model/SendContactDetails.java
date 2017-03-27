package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="sendcontact")
public class SendContactDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String name;
	
	@NotNull
	@Email
	@Size(min = 2, max = 80)
	private String mail;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String msg;
	
	public SendContactDetails(){}

	public SendContactDetails(long id)
	{
		this.id=id;
	}
	public SendContactDetails(long id, String name, String mail,String msg)
	{
		this.id=id;
		this.name=name;
		this.mail=mail;
		this.msg=msg;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

	