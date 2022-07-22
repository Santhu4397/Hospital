package com.ty.Hospital.util;

import java.util.List;

public class FloorHelp {
	private int _id;
	private int floorNumber;
	private String type;
	private List<RoomsHelp> rooms;

	public List<RoomsHelp> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomsHelp> rooms) {
		this.rooms = rooms;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
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

	@Override
	public String toString() {
		return "FloorHelp [_id=" + _id + ", floorNumber=" + floorNumber + ", type=" + type + ", rooms=" + rooms + "]";
	}

}
