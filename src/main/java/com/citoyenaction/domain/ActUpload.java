package com.citoyenaction.domain;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ActUpload")
public class ActUpload {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@Column( unique = true, nullable = false, precision = 19)
	private long actUploadId;
	
	@Column(name = "fileId")
	private long fileId;
	
	@Column(name = "fileName")
	private String fileName;
	
	@Column(name = "fileData")
	@Lob
	private byte[] fileData;
	
	@ManyToOne
	@JoinColumn(name = "ActNonCiviqueId", nullable = false)
	private ActNonCivique actNonCivique;

	public long getActUploadId() {
		return actUploadId;
	}

	public void setActUploadId(long actUploadId) {
		this.actUploadId = actUploadId;
	}

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public ActNonCivique getActNonCivique() {
		return actNonCivique;
	}

	public void setActNonCivique(ActNonCivique actNonCivique) {
		this.actNonCivique = actNonCivique;
	}

	

	
	

	

}
