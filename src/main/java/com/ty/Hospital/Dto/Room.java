package com.ty.Hospital.Dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Rooms")
public class Room {
	@Transient
	public static final String SEQUENCE_NAME = "room_Sequences";
	@Id
	private int id;
	private int roomNumber;
	private String type;
	private User user;
	private Floor floor;
	private List<Bed> bed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
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

}
