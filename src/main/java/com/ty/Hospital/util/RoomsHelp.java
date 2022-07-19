package com.ty.Hospital.util;

public class RoomsHelp {
	private int _id;
	private int roomNumber;
	private String type;

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
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

	@Override
	public String toString() {
		return "RoomsHelp [_id=" + _id + ", roomNumber=" + roomNumber + ", type=" + type + "]";
	}

}
