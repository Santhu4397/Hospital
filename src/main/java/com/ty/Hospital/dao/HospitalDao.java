package com.ty.Hospital.dao;

import java.util.List;


import com.ty.Hospital.Dto.Building;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ty.Hospital.Dto.Branch;

import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.util.Hospitalhelp;

public interface HospitalDao {

	public Hospital saveHospital(Hospital hospital, int userID);

	public Hospital getHospitalById(int hid);

	public List<Hospital> getAllHospital();

	public Hospital updateHospitalById(int hid, Hospital hospital);

	public boolean deleteHospital(int hid);

	public Hospital getByBranchId(int id);


	public Hospitalhelp getByBuildingId(int id);

	public Hospitalhelp getHospitalByFloorId(int id);

	public Hospitalhelp getHospitalByRoomId(int id);

}
