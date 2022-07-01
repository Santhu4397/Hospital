package com.ty.Hospital.dao;

import java.util.List;

import com.ty.Hospital.Dto.Facility;

public interface FacilityDao {

	public Facility saveFacility(Facility facility, int buildingId);

	public Facility getFacilityById(int facilityId);

	public List<Facility> getAllFacilitys();

	public Facility updateFacility(Facility facility, int facilityId);

	public boolean deleteFacilityById(int facilityId);

}
