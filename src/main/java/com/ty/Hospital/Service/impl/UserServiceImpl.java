package com.ty.Hospital.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.LoginCredinstials;
import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Excipation.IdNotFound;
import com.ty.Hospital.Service.UserService;
import com.ty.Hospital.dao.UserDao;
import com.ty.Hospital.util.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> entity = null;
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("User Saved Successfully");
		structure.setData(userDao.saveUSer(user));
		entity = new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		return entity;
	}
	@Override
	public  ResponseEntity<ResponseStructure<User>> loginUser(LoginCredinstials credinstials) {
		
		ResponseStructure<User> structure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> entity = null;
		User user = userDao.findByEmailIdAndPassword(credinstials.getEmailId(), credinstials.getPassword());

		if (user != null) {
			structure.setData(user);
			structure.setMessage("Login Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			entity = new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
			return entity;
		} else {
			structure.setData(user);
			structure.setMessage("Login creadentials are invalid");
			structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			entity = new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.BAD_REQUEST);
			return entity;
		}

	}
	@Override
	public ResponseEntity<ResponseStructure<User>> getuserById(int userId) {
		ResponseStructure<User> structure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> entity = null;
		User user = userDao.getUserById(userId);
		if (user != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(userDao.getUserById(userId));
			structure.setMessage(" Fetching User Details Successfully");
			entity = new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound(userId + "userID Not Found");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
		ResponseEntity<ResponseStructure<List<User>>> entity = null;
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(userDao.getAllUser());
		entity = new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> updateUserById(int userId, User user) {
		ResponseStructure<User> structure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> entity = null;

		User user2 = userDao.updateUserById(userId, user);
		if (user2 != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("update User Successfully");
			structure.setData(user);
			entity = new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("User ID :" + userId + "does not exist");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteUserById(int userId) {
		ResponseStructure<String> responsestructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity = null;
		if (userDao.deleteUser(userId)) {
			responsestructure.setStatusCode(HttpStatus.OK.value());
			responsestructure.setMessage("UserDeleted Successfully");
			responsestructure.setData("User deleted");
			responseEntity = new ResponseEntity<ResponseStructure<String>>(responsestructure, HttpStatus.OK);
			return responseEntity;
		} else {
			responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responsestructure.setMessage("Id : " +userId + "is not found");
			responsestructure.setData("No user is deleted");
			responseEntity = new ResponseEntity<ResponseStructure<String>>(responsestructure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}

}
