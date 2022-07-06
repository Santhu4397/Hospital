package com.ty.Hospital.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Facility;
import com.ty.Hospital.Excipation.IdNotFound;
import com.ty.Hospital.Service.FacilityService;
import com.ty.Hospital.dao.BuildingDao;
import com.ty.Hospital.dao.FacilityDao;
import com.ty.Hospital.util.ResponseStructure;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Autowired
	private FacilityDao dao;

	@Autowired
	private BuildingDao buildingDao;

	@Override
	public ResponseEntity<ResponseStructure<Facility>> saveFacility(Facility facility, int buildingId) {
		Building building = buildingDao.getBuildingById(buildingId);
		if (building != null) {
			ResponseStructure<Facility> structure = new ResponseStructure<Facility>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Facility Created succesfuly");
			structure.setData(dao.saveFacility(facility, buildingId));
			return new ResponseEntity<ResponseStructure<Facility>>(structure, HttpStatus.OK);
		}
		throw new IdNotFound(buildingId + "Building id not found");

	}

	@Override
	public ResponseEntity<ResponseStructure<Facility>> getFacilityById(int facilityId) {
		Facility facility = dao.getFacilityById(facilityId);
		if (facility != null) {
			ResponseStructure<Facility> structure = new ResponseStructure<Facility>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Facility is Fetched Successfully");
			structure.setData(dao.getFacilityById(facilityId));
			return new ResponseEntity<ResponseStructure<Facility>>(structure, HttpStatus.OK);
		}
		throw new IdNotFound(facilityId + "Facility Id Not Found");
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Facility>>> getAllFacilitys() {
		ResponseStructure<List<Facility>> structure = new ResponseStructure<List<Facility>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("List Hospitals");
		return new ResponseEntity<ResponseStructure<List<Facility>>>(structure, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ResponseStructure<Facility>> updateFacility(Facility facility, int facilityId) {
		Facility facility2 = dao.getFacilityById(facilityId); 
		if(facility2!=null) {
			ResponseStructure<Facility> structure = new ResponseStructure<Facility>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Facility Updated Successfully");
			structure.setData(dao.updateFacility(facility2, facilityId));
			return new ResponseEntity<ResponseStructure<Facility>>(structure,HttpStatus.OK);
		}
		throw new IdNotFound(facilityId+"Facility Id Not Found");
	}

	@Override
	public ResponseEntity<ResponseStructure<Boolean>> deleteFacilityById(int facilityId) {
		Facility facility = dao.getFacilityById(facilityId);
		if (facility != null) {
			ResponseStructure<Boolean> structure = new ResponseStructure<Boolean>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Facility deleted Successfully");
			structure.setData(dao.deleteFacilityById(facilityId));
			return new ResponseEntity<ResponseStructure<Boolean>>(structure,HttpStatus.OK);
		}
		throw new IdNotFound("Facility id not found");
	}

}
