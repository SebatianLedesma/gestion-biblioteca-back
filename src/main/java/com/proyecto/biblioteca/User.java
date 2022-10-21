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
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	
	@Column(name = "city_id") 
	private int city_id;
	@Column(name = "country_id") 
	private int country_id;
	@Column(name = "email") 
	private String email;
	@Column(name = "password") 
	private String password;
	@Column(name = "province_id ") 
	private int province_id ;
	@Column(name = "deleted") 
	private int deleted;

	
	
	
	public User() {
		
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public int getCity_id() {
		return city_id;
	}




	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}




	public int getCountry_id() {
		return country_id;
	}




	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getProvince_id() {
		return province_id;
	}




	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}




	public int getDeleted() {
		return deleted;
	}




	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
	
	
}