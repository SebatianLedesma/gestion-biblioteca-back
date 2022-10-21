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
@Table(name = "institution")
@EntityListeners(AuditingEntityListener.class)
public class Institucion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "cuit_number") 
	private String cuit_number;	
	@Column(name = "name") 
	private String name;
	@Column(name = "user_id") 
	private int user_id;
	@Column(name = "deleted") 
	private int deleted;
	
	public Institucion() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCuit_number() {
		return cuit_number;
	}

	public void setCuit_number(String cuit_number) {
		this.cuit_number = cuit_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	