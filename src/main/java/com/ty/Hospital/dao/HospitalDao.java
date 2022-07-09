package com.ty.Hospital.dao;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Hospital;

public interface HospitalDao {

	public Hospital saveHospital(Hospital hospital, int userID);

	public Hospital getHospitalById(int hid);

	public List<Hospital> getAllHospital();

	public Hospital updateHospitalById(int hid, Hospital hospital);

	public boolean deleteHospital(int hid);

	public Hospital getByBranchId(int id);

	public Hospital getByBuildingId(int id) ;
}
