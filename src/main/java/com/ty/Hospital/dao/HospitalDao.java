package com.ty.Hospital.dao;

import java.util.List;

import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.util.ListBean;
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

	public ListBean getListFloorByBuildingId(int id);

}
