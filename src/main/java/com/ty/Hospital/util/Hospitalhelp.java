package com.ty.Hospital.util;

public class Hospitalhelp {
int _id;
String name;
String website;
String gst;
UserHelp user;
Branchshelp branchs;
public int get_id() {
	return _id;
}
public void set_id(int _id) {
	this._id = _id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
public String getGst() {
	return gst;
}
public void setGst(String gst) {
	this.gst = gst;
}
public UserHelp getUser() {
	return user;
}
public void setUser(UserHelp user) {
	this.user = user;
}
public Branchshelp getBranchs() {
	return branchs;
}
public void setBranchs(Branchshelp branchs) {
	this.branchs = branchs;
}
@Override
public String toString() {
	return "Hospitalhelp [_id=" + _id + ", name=" + name + ", website=" + website + ", gst=" + gst + ", user=" + user
			+ ", branchs=" + branchs + "]";
}

}
