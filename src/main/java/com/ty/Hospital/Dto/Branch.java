package com.ty.Hospital.Dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "Branch")
public class Branch {
	@Transient
	public static final String SEQUENCE_NAME = "branch_sequence";
	@Id
	private int id;
	private String branch_Name;
	private String country;
	private String state;
	private String city;
	private long branch_Number;
	private int pincode;
	private User user;
	private Hospital hospital;
	private List<Building> buildings;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getBranch_Number() {
		return branch_Number;
	}

	public void setBranch_Number(long branch_Number) {
		this.branch_Number = branch_Number;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
