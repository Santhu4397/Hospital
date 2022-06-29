package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ty.Hospital.Dto.Building;

public interface BuildingRepo extends MongoRepository<Building, Integer> {

}
