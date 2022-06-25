package com.ty.Hospital.Dto;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation ="Users")

public class User {
	 
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	@Id
	private int id;
	private String name;
	private String emailId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public User(String name, String emailId) {
		super();
		this.name = name;
		this.emailId = emailId;
	}
	public User() {
		super();
	}
	
	
}
