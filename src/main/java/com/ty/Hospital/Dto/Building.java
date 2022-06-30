package com.ty.Hospital.Dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bulding")
public class Building {
	@Transient
	public static final String SEQUENCE_NAME = "building_sequence";
	@Id
	private int id;
	private String building_Name;
	private User user;
	private Branch branch;
	private List<Floor> floors;
	private List<Facility> facilities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuilding_Name() {
		return building_Name;
	}

	public void setBuilding_Name(String building_Name) {
		this.building_Name = building_Name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	public List<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

}
