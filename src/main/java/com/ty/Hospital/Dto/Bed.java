package com.ty.Hospital.Dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Beds")
public class Bed {
	@Transient
	public static final String SEQUENCE_NAME = "bed_Sequences";
	@Id
	private int id;
	private int bedNumber;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	

}
