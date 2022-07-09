package com.ty.Hospital.Service;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.util.ResponseStructure;

public interface FloorService {
	
	ResponseEntity<ResponseStructure<Hospital>> saveFloorByBuilding(int buildingId, Floor floor);
}
