package com.ty.Hospital.util;

public class Buildindhelp {
	int _id;
	String building_Name;
	FloorHelp floors;
	
	
	
	public FloorHelp getFloors() {
		return floors;
	}
	public void setFloors(FloorHelp floors) {
		this.floors = floors;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getBuilding_Name() {
		return building_Name;
	}
	public void setBuilding_Name(String building_Name) {
		this.building_Name = building_Name;
	}
	@Override
	public String toString() {
		return "Buildindhelp [_id=" + _id + ", building_Name=" + building_Name + ", floors=" + floors + "]";
	}
	
	

}
