package com.ty.Hospital.dao;

import java.util.List;

import com.ty.Hospital.Dto.User;

public interface UserDao {
	
	public User saveUSer(User user);
	
	public User getUserById(int uid);
	
	public List<User> getAllUser();
	
	public User updateUserById(int uid, User user);
	
	public boolean deleteUser(int uid);
	
}
