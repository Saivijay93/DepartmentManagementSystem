package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="signinstaff")
public class SigninStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String idno;
	
	
	@NotNull
	@Size(min = 2, max = 80)
	private String password;
	
	public SigninStaff(){}
	
	public SigninStaff(long id)
	{
		this.id=id;
	}
	public SigninStaff(long id, String idno, String password)
	{
		this.id=id;
		this.idno=idno;
		this.password=password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
