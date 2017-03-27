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
@Table(name="adminstudent")
public class Adminstudent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 1, max = 10)
	private String studRoll;
	
	
	@NotNull
	@Size(min = 1, max = 80)
	private String studName ;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String batch;
	
	@NotNull
	@Email
	@Size(min = 1, max = 80)
	private String email;
	
	@NotNull
	@Size(min = 1, max = 13)
	private String mobile ;
	
    public Adminstudent(){
		
	}
	public Adminstudent(long id){
		this.id=id;
	}
	
	/*public Adminstudent(String studRoll) {
		super();
		this.studRoll = studRoll;
	}*/
	
	public Adminstudent(long id, String studRoll, String studName, String batch, String email, String mobile) {
		super();
		this.id = id;
		this.studRoll = studRoll;
		this.studName = studName;
		this.batch = batch;
		this.email = email;
		this.mobile = mobile;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudRoll() {
		return studRoll;
	}
	public void setStudRoll(String studRoll) {
		this.studRoll = studRoll;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
