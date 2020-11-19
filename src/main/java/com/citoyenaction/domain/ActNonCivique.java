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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column(name = "date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date date;
	
	@Column(name = "photo", nullable = false)
	private byte photo;
	
	@Column(name = "video", nullable = false)
	private byte video;
	
	@Column(name = "statut", nullable = false)
	private String statut;
		

	@ManyToOne
    @JoinColumn(name="user_id",nullable=false)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Reaction> reactions= new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ActUpload> actUploads= new ArrayList<>();
	

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
	

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	

}
