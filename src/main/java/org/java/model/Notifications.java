package org.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="notifications")
public class Notifications {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String per;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String msg;
	
	
	@NotNull
	@Size(min = 2, max = 80)
	private String dat;
	
	public Notifications(){
		
	}
	public Notifications(long id){
		
	}
	public Notifications(long id, String per, String msg, String dat){
		super();
		this.id=id;
		this.per=per;
		this.msg=msg;
		this.dat=dat;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDat() {
		return dat;
	}
	public void setDat(String dat) {
		this.dat = dat;
	}
	
	
	
}
