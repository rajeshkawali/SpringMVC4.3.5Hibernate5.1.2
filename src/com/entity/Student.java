package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	
	@Id
    @Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="CONTACT")
	private int contact;
	
	public Student(){
	
	}
	public Student(int id, String name, int contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}	
}
