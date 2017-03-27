package org.java.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

@Entity
@Table(name="syllabus")
public class Syllabus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	//@Size(min = 1, max = 80)
	private Blob element;
	
    public Syllabus(){
		
	}
	public Syllabus(long id){
		this.id=id;
	}
	
	public Syllabus(long id, Blob element) {
		super();
		this.id = id;
		this.element = element;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Blob getElement() {
		return element;
	}
	public void setElement(Blob element) {
		this.element = element;
	}
	
}
