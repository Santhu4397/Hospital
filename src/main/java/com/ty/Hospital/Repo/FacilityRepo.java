package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ty.Hospital.Dto.Facility;

public interface FacilityRepo extends MongoRepository<Facility, Integer> {
	

}
