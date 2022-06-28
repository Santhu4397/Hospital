package com.ty.Hospital.Dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "encounters")
public class Encounter {
	@Transient
	public static final String SEQUENCE_NAME = "encounter_Sequences";
	@Id
	private int id;
	private String reason;
	private LocalDateTime dateOfAdmit;
	private String createrName;
	private User user;
	private Bed bed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDateTime getDateOfAdmit() {
		return dateOfAdmit;
	}

	public void setDateOfAdmit(LocalDateTime dateOfAdmit) {
		this.dateOfAdmit = dateOfAdmit;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

}
