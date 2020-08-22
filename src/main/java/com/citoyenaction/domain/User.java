package com.citoyenaction.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@Column( unique = true, nullable = false, precision = 19)
	private long userId;
	
	@Column(name = "nom", nullable = false, length = 255)
	private String nom;

	@Column(name = "prenom", nullable = false, length = 255)
	private String prenom;

	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	@Column(name = "date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date date;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ActNonCivique> actNonCiviques= new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Reaction> reactions= new ArrayList<>();
	
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
	



}
