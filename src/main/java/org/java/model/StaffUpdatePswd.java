package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="staffupdatepswd")
public class StaffUpdatePswd {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 80)
	private int otp;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String number;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String password;
	
	public StaffUpdatePswd(){}
	
	public StaffUpdatePswd(long id)
	{
		this.id=id;
	}
	public StaffUpdatePswd(long id,int otp,String number, String password)
	{
		this.id=id;
		this.otp=otp;
		this.number=number;
		this.password=password;
		
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}

	