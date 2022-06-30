package com.ty.Hospital.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Repo.UserRepo;

public interface UserDao {
	

	public User saveUSer(User user);

	public User getUserById(int uid);

	public List<User> getAllUser();

	public User updateUserById(int uid, User user);

	public boolean deleteUser(int uid);
	
	public  User findByEmailIdAndPassword(String emailId, String password);

}
