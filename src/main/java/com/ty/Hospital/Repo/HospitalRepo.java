package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ty.Hospital.Dto.Hospital;

public interface HospitalRepo extends MongoRepository<Hospital, Integer> {

//	@Query(value = "{'branchs':{$elemMatch:{'id:?0'}}}")
	//@Query(value = "{ 'branchs.id':?0}",fields = "{'branchs.id':1,'branchs.branch_Name':1}")
//	@Query(value = "{ 'branchs.id':?0}",fields = "{'id':1}")
	@Query(value = "{ 'branchs.id':?0}")
	public Hospital getBybranchId(int id);
	@Query(value = "{'branchs.buildings.id':?0}",fields = "{'branchs.id':1}")
	public Hospital getByBuildingId(int id);
	
	
	
	
	
}
