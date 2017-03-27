package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="signinstudent")
public class SigninStudent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String rollno;
	
	
	@NotNull
	@Size(min = 2, max = 80)
	private String password;
	
	public SigninStudent(){}
	
	public SigninStudent(long id)
	{
		this.id=id;
	}
	public SigninStudent(long id, String rollno, String password)
	{
		this.id=id;
		this.rollno=rollno;
		this.password=password;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
