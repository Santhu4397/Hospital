package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ty.Hospital.Dto.Bed;

public interface BedRepository extends MongoRepository<Bed, Integer>{

}
