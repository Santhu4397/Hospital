package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.LoginCredinstials;
import com.ty.Hospital.Dto.User;
import com.ty.Hospital.daoimpl.UserDaoImpl;
import com.ty.Hospital.util.ResponseStructure;

public interface UserService {

	public ResponseEntity<ResponseStructure<User>> saveUser(User user);

	public ResponseEntity<ResponseStructure<User>> getuserById(int userId);

	public ResponseEntity<ResponseStructure<List<User>>> getAllUser();

	public ResponseEntity<ResponseStructure<User>> updateUserById(int userId, User user);

	public ResponseEntity<ResponseStructure<String>> deleteUserById(int userId);

	public ResponseEntity<ResponseStructure<User>> loginUser(LoginCredinstials credinstials);
}
