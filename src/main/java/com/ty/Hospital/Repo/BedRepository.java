package com.ty.Hospital.Repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ty.Hospital.Dto.Bed;

public interface BedRepository extends MongoRepository<Bed, Integer>{
	
	@Query("{id :?0}")                                                  //SQL Equivalent : SELECT * FROM Bed WHERE ID=?
    public Bed getBedById(Integer id);

}
