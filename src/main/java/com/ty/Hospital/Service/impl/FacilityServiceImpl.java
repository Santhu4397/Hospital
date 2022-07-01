package com.ty.Hospital.Service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Facility;
import com.ty.Hospital.Service.FacilityService;
import com.ty.Hospital.util.ResponseStructure;

public class FacilityServiceImpl implements FacilityService {

	@Override
	public ResponseEntity<ResponseStructure<Facility>> saveFacility(Facility facility, int buildingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Facility>> getFacilityById(int facilityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Facility>>> getAllFacilitys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Facility>> updateFacility(Facility facility, int facilityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Boolean>> deleteFacilityById(int facilityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
