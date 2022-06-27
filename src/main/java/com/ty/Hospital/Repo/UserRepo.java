package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ty.Hospital.Dto.User;

public interface UserRepo extends MongoRepository<User, Integer> {

}
