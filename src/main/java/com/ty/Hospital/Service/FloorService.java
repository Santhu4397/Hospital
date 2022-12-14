package com.ty.Hospital.Service;


import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.util.ListBean;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ResponseStructure;

public interface FloorService {
	public ResponseEntity<ResponseStructure<Hospital>> saveFloor(Floor floor, int buildingId);
	
	public ResponseEntity<ResponseStructure<Hospitalhelp>> getFloorById(int FloorId);
	
	public ResponseEntity<ResponseStructure<ListBean>> getAllFloor(int buildingId);
		
	public ResponseEntity<ResponseStructure<Hospital>> updateFloor(Floor floor, int FloorId);
		
	public ResponseEntity<ResponseStructure<String>> deleteFloorById(int FloorId);
}
