package com.ty.Hospital.Dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Room {
	@Transient
	public static final String SEQUENCE_NAME = "room_Sequences";
	@Id
	private int _id;
	private int roomNumber;
	private String type;

	private Floor floor;
	//private List<Bed> bed;

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
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

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

//	public List<Bed> getBed() {
//		return bed;
//	}
//
//	public void setBed(List<Bed> bed) {
//		this.bed = bed;
//	}

}
