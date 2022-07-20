package com.ty.Hospital.util;

public class Branchshelp {

int _id;
String branch_Name;
String country;
String state;
int branch_Number;
int pincode;
Buildindhelp buildings;
public int get_id() {
	return _id;
}
public void set_id(int _id) {
	this._id = _id;
}
public String getBranch_Name() {
	return branch_Name;
}
public void setBranch_Name(String branch_Name) {
	this.branch_Name = branch_Name;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getBranch_Number() {
	return branch_Number;
}
public void setBranch_Number(int branch_Number) {
	this.branch_Number = branch_Number;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public Buildindhelp getBuildings() {
	return buildings;
}
public void setBuildings(Buildindhelp buildings) {
	this.buildings = buildings;
}
@Override
public String toString() {
	return "Branchshelp [_id=" + _id + ", branch_Name=" + branch_Name + ", country=" + country + ", state=" + state
			+ ", branch_Number=" + branch_Number + ", pincode=" + pincode + ", buildings=" + buildings + "]";
}
}
