package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String studentName;
	
	
	@NotNull
	@Size(min = 2, max = 80)
	private String rollno;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String password;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String password2;
		
	/*constructors*/
	public Student(){
		
	}
	public Student(long id){
		this.id=id;
	}
	
	
	public Student(long id, String studentName, String rollno, String password, String password2) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.rollno = rollno;
		this.password = password;
		this.password2 = password2;
		
	}
	/*-----end of constructors*/
	/*----getters and setters*/
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
/*	-------end of getters and setters------*/
	
}
