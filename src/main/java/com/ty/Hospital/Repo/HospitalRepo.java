package com.ty.Hospital.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ty.Hospital.Dto.Hospital;

public interface HospitalRepo extends MongoRepository<Hospital, Integer> { 

//	@Query(value = "{'branchs':{$elemMatch:{'id:?0'}}}")
	// @Query(value = "{ 'branchs.id':?0}",fields =
	// "{'branchs.id':1,'branchs.branch_Name':1}")
//	@Query(value = "{ 'branchs.id':?0}",fields = "{'id':1}")
	@Query(value = "{'branchs.id':?0}")
	public Hospital getByBranchId(int id);
//	@Query(value = "db.Hospitals.aggregate[{$unwind:'$branchs'},{$unwind:'$branchs.buildings'},{$match:{'$branchs.buildings._id':?0}}]")
//	public List<Branch> getByBuildingId(int id);
//	@Query(value = "{'$meta':'branchs.buldings.id:?0'}")
//	public List<Branch> getByBuildingId(int id);
	@Query(value = "{'branchs.buildings.id':?0}")
	public  Hospital getByBuildingId(int id);



	
}
