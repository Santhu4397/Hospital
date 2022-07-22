package com.ty.Hospital.util;

import java.util.List;

public class ListOfRoom {
	List<RoomsHelp> _id;

	public List<RoomsHelp> get_id() {
		return _id;
	}

	public void set_id(List<RoomsHelp> _id) {
		this._id = _id;
	}

	@Override
	public String toString() {
		return "ListOfRoom [_id=" + _id + "]";
	}

}
