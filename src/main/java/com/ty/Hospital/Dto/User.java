package com.ty.Hospital.Dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Users")

public class User {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	@Id
	private int id;
	private String name;
	private String emailId;
	private String password;
	private Long phone;
	private int age;
	private String gender;
	private String role_discription;
	private List<Encounter> encounters;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole_discription() {
		return role_discription;
	}

	public void setRole_discription(String role_discription) {
		this.role_discription = role_discription;
	}

	public User(int id, String name, String emailId, String password, Long phone, int age, String gender,
			String role_discription) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.role_discription = role_discription;
	}

	public User() {
		super();
	}

}
