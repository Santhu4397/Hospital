package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ty.Hospital.Dto.User;

public interface UserRepo extends MongoRepository<User, Integer> {
	
	@Query("{ 'emailId': ?0, 'password': ?1}")
	public User findByEmailIdAndPassword(String emailId, String password);
	
	public User findByEmailId(String email);
}
