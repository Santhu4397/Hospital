package com.ty.Hospital.Dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "facility")
public class Facility {
	@Transient
	public static final String SEQUENCE_NAME = "facility_Sequences";
	@Id
	private int id;
	private String diagnosticType;
	private double cost;
	private User user;
	private Building building;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiagnosticType() {
		return diagnosticType;
	}

	public void setDiagnosticType(String diagnosticType) {
		this.diagnosticType = diagnosticType;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

}
