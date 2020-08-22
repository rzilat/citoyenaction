package com.citoyenaction.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reaction")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Reaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@Column(unique = true,name="reactionId", nullable = false, precision = 19)
	private long reactionId;
	
	@Column(name = "titre", nullable = false, length = 255)
	private String titre;
	
	@Column(name = "commentaire", nullable = false, length = 255)
	private String commentaire;
	
	@Column(name = "evaluation", nullable = false, length = 255)
	private String evaluation;
	
	@Column(name = "date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date date;
	
	
	@ManyToOne
    @JoinColumn(name="userId",nullable=false)
	private User user;
	
	@ManyToOne
    @JoinColumn(name="actNonCiviqueId",nullable=false)
	private ActNonCivique actNonCivique;

	public long getReactionId() {
		return reactionId;
	}

	public void setReactionId(long reactionId) {
		this.reactionId = reactionId;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ActNonCivique getActNonCivique() {
		return actNonCivique;
	}

	public void setActNonCivique(ActNonCivique actNonCivique) {
		this.actNonCivique = actNonCivique;
	}
	
	
	
	
	


}
