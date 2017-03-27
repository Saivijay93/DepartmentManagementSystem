package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="staff")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String staffName;
	
	
	@NotNull
	@Size(min = 2, max = 80)
	private String idno ;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String password;
	
	@NotNull
	@Size(min = 2, max = 80)
	private String password2;
		
	public Staff(){
	}
	public Staff(long id){
		this.id=id;
	}
	
	
	public Staff(long id, String staffName, String idno, String password, String password2) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.idno = idno;
		this.password = password;
		this.password2 = password2;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
