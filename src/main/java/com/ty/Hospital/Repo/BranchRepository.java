package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ty.Hospital.Dto.Branch;

public interface BranchRepository extends MongoRepository<Branch, Integer>{

}
