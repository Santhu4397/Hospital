package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Facility;
import com.ty.Hospital.util.ResponseStructure;

public interface FacilityService {
	public ResponseEntity<ResponseStructure<Facility>> saveFacility(Facility facility, int buildingId);
	
	public ResponseEntity<ResponseStructure<Facility>> getFacilityById(int facilityId);
	
	public ResponseEntity<ResponseStructure<List<Facility>>> getAllFacilitys();
		
	public ResponseEntity<ResponseStructure<Facility>> updateFacility(Facility facility, int facilityId);
		
	public ResponseEntity<ResponseStructure<Boolean>> deleteFacilityById(int facilityId);

}
