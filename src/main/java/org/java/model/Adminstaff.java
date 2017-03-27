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
@Table(name="adminstaff")
public class Adminstaff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String staffId;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String staffName ;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String designation;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String qualification;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String experience;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String branch;
	
	@NotNull
	@Size(min = 1, max = 15)
	private String mobile ;

	@NotNull
	@Email
	@Size(min = 1, max = 80)
	private String email ;
	
    public Adminstaff(){
		
	}
	public Adminstaff(long id){
		this.id=id;
	}
	
	public Adminstaff(long id, String staffId, String staffName, String designation, String qualification, String experience, String branch, String mobile, String email) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.staffName = staffName;
		this.designation = designation;
		this.qualification = qualification;
		this.experience = experience;
		this.branch = branch;
		this.mobile = mobile;
		this.email = email;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
