package com.proyecto.biblioteca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	@Column(name = "name") 
	private String name;
	@Column(name = "surname") 
	private String surname;
	@Column(name = "document_number") 
	private String document_number;
	@Column(name = "date_of_birth") 
	private String date_of_birth;
	@Column(name = "user_id") 
	private int user_id;
	@Column(name = "deleted") 
	private int deleted;
	
	
	
	public Estudiante() {
		
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getDocument_number() {
		return document_number;
	}



	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}



	public String getDate_of_birth() {
		return date_of_birth;
	}



	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public int getDeleted() {
		return deleted;
	}



	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
	
}