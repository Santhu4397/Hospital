package com.ty.Hospital.Dto;
 
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

public class Floor {
	@Transient
	public static final String SEQUENCE_NAME = "floor_Sequences";
	@Id
	private int _id;
	private int floorNumber;
	private String type;
	private List<Room> rooms;


	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
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

	

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	

	

}
