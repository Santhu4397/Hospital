package com.ty.Hospital.Controller.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ty.Hospital.Dto.Hospital;

public interface HospitalRepo extends MongoRepository<Hospital, Integer> {

}
