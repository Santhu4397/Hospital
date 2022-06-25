package com.ty.Hospital.Dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Hospitals")

public class Hospital {
	@Transient
	public static final String SEQUENCE_NAME = "hospital_sequence";
	@Id
	private int id;
	private String name;
	private String website;
	private Long phone;
	private String email;
	private String gst;

	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public Hospital(int id, String name, String website, Long phone, String email, String gst, User user) {
		super();
		this.id = id;
		this.name = name;
		this.website = website;
		this.phone = phone;
		this.email = email;
		this.gst = gst;
		this.user = user;
	}

	public Hospital() {
		super();
	}

}
