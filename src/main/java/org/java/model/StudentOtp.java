package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="studentotp")
public class StudentOtp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String rollno;

public StudentOtp(){
		
	}
	
	public StudentOtp(long id)
	{
		this.id=id;
	}
	public StudentOtp(long id, String rollno)
	{
		this.id=id;
		this.rollno=rollno;
		
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

}

	