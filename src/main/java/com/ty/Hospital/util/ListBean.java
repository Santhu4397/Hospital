package com.ty.Hospital.util;

import java.util.List;

public class ListBean {
	List<Object> _id;

	public List<Object> get_id() {
		return _id;
	}

	public void set_id(List<Object> _id) {
		this._id = _id;
	}

	@Override
	public String toString() {
		return "RoomBean [_id=" + _id + "]";
	}
	

}
