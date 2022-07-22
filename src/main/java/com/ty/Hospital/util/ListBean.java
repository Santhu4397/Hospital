package com.ty.Hospital.util;

import java.util.List;

import com.ty.Hospital.Dto.Room;

public class ListBean {
	List<FloorHelp> _id;


	public List<FloorHelp> get_id() {
		return _id;
	}

	public void set_id(List<FloorHelp> _id) {
		this._id = _id;
	}
	
	
	
	@Override
	public String toString() {
		return "ListBean [_id=" + _id + ", rooms=" + "]";
	}

	



	
	
	

}
