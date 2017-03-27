package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="results")
public class Results {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String rollno;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String sub1;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String marks1;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String sub2;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String marks2;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String sub3;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String marks3;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String sub4;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String marks4;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String sub5;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String marks5;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String sem;

	@NotNull
	@Size(min = 1, max = 80)
	private String mid;
	
	public Results(){
		
	}
	public Results(long id){
		this.id=id;		
	}
	public Results(long id, String rollno, String sub1, String marks1, String sub2, String marks2,String sub3, String marks3, String sub4, String marks4, String sub5, String marks5, String sem, String mid){
		super();
		this.id=id;
		this.rollno=rollno;
		this.sub1=sub1;
		this.marks1=marks1;
		this.sub2=sub2;
		this.marks2=marks2;
		this.sub3=sub3;
		this.marks3=marks3;
		this.sub4=sub4;
		this.marks4=marks4;
		this.sub5=sub5;
		this.marks5=marks5;
		this.sem=sem;
		this.mid=mid;
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
	public String getSub1() {
		return sub1;
	}
	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}
	public String getMarks1() {
		return marks1;
	}
	public void setMarks1(String marks1) {
		this.marks1 = marks1;
	}
	public String getSub2() {
		return sub2;
	}
	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
	public String getMarks2() {
		return marks2;
	}
	public void setMarks2(String marks2) {
		this.marks2 = marks2;
	}
	public String getSub3() {
		return sub3;
	}
	public void setSub3(String sub3) {
		this.sub3 = sub3;
	}
	public String getMarks3() {
		return marks3;
	}
	public void setMarks3(String marks3) {
		this.marks3 = marks3;
	}
	public String getSub4() {
		return sub4;
	}
	public void setSub4(String sub4) {
		this.sub4 = sub4;
	}
	public String getMarks4() {
		return marks4;
	}
	public void setMarks4(String marks4) {
		this.marks4 = marks4;
	}
	public String getSub5() {
		return sub5;
	}
	public void setSub5(String sub5) {
		this.sub5 = sub5;
	}
	public String getMarks5() {
		return marks5;
	}
	public void setMarks5(String marks5) {
		this.marks5 = marks5;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	
	
	
}
