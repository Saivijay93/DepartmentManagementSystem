package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="timetable")
public class Timetable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String sem;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String nordays;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String period1;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String period2;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String period3;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String period4;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String period5;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String period6;
	
	@NotNull
	@Size(min = 1, max = 80)
	private String period7;
	
	public Timetable(){
		
	}
	
	public Timetable(long id){
		this.id=id;
	}
	
	public Timetable(long id, String sem,String nordays, String period1, String period2, String period3, String period4, String period5, String period6, String period7){
		super();
		this.id=id;
		this.sem=sem;
		this.nordays=nordays;
		this.period1=period1;
		this.period2=period2;
		this.period3=period3;
		this.period4=period4;
		this.period5=period5;
		this.period6=period6;
		this.period7=period7;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getNordays() {
		return nordays;
	}

	public void setNordays(String nordays) {
		this.nordays = nordays;
	}

	public String getPeriod1() {
		return period1;
	}

	public void setPeriod1(String period1) {
		this.period1 = period1;
	}

	public String getPeriod2() {
		return period2;
	}

	public void setPeriod2(String period2) {
		this.period2 = period2;
	}

	public String getPeriod3() {
		return period3;
	}

	public void setPeriod3(String period3) {
		this.period3 = period3;
	}

	public String getPeriod4() {
		return period4;
	}

	public void setPeriod4(String period4) {
		this.period4 = period4;
	}

	public String getPeriod5() {
		return period5;
	}

	public void setPeriod5(String period5) {
		this.period5 = period5;
	}

	public String getPeriod6() {
		return period6;
	}

	public void setPeriod6(String period6) {
		this.period6 = period6;
	}

	public String getPeriod7() {
		return period7;
	}

	public void setPeriod7(String period7) {
		this.period7 = period7;
	}

}
