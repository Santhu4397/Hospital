package com.ty.Hospital.dao;

import java.util.List;

<<<<<<< HEAD
import com.ty.Hospital.Dto.Building;
=======
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ty.Hospital.Dto.Branch;
>>>>>>> 0c530c579a8a141b41167b6ca8ee2eb51045d43e
import com.ty.Hospital.Dto.Hospital;

public interface HospitalDao {

	public Hospital saveHospital(Hospital hospital, int userID);

	public Hospital getHospitalById(int hid);

	public List<Hospital> getAllHospital();

	public Hospital updateHospitalById(int hid, Hospital hospital);

	public boolean deleteHospital(int hid);

	public Hospital getByBranchId(int id);

<<<<<<< HEAD
	public Hospital getByBuildingId(int id);
//	public Building getBranchByBuildingId(int id);
	
=======
	public Hospital getByBuildingId(int id) ;
>>>>>>> 0c530c579a8a141b41167b6ca8ee2eb51045d43e
}
