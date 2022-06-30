package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ty.Hospital.Dto.Floor;

public interface FloorRepository extends MongoRepository<Floor, Integer>{

}
