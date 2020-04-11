package com.citoyenaction.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ActNonCivique")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ActNonCivique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@Column(unique = true, nullable = false, precision = 19)
	private long actNonCiviqueId;
	
	@Column(name = "titre", nullable = false, length = 255)
	private String titre;
	
	@Column(name = "description", nullable = false, length = 255)
	private String description;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "photo", nullable = false)
	private byte photo;
	
	@Column(name = "video", nullable = false)
	private byte video;

	public long getActNonCiviqueId() {
		return actNonCiviqueId;
	}

	public void setActNonCiviqueId(long actNonCiviqueId) {
		this.actNonCiviqueId = actNonCiviqueId;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte getPhoto() {
		return photo;
	}

	public void setPhoto(byte photo) {
		this.photo = photo;
	}

	public byte getVideo() {
		return video;
	}

	public void setVideo(byte video) {
		this.video = video;
	}
	
	

}
