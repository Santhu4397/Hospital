package com.ty.Hospital.Dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;

@Document(collation = "Beds")
@ApiModel(value = "Bed class", description = "Bed for the encounter ")
public class Bed {
	@Transient
	public static final String SEQUENCE_NAME = "bed_Sequences";
	@Id
	private int id;
	private int bedNumber;
	private String type;
	private User user;
	private Room room;
	private List<Encounter> encounters;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

}
