package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.util.ResponseStructure;

public interface FloorService {
	public ResponseEntity<ResponseStructure<Floor>> saveFloor(Floor floor, int buildingId);
	
	public ResponseEntity<ResponseStructure<Floor>> getFloorById(int FloorId);
	
	public ResponseEntity<ResponseStructure<List<Floor>>> getAllFloor();
		
	public ResponseEntity<ResponseStructure<Floor>> updateFloor(Floor floor, int FloorId);
		
	public ResponseEntity<ResponseStructure<Floor>> deleteFloorById(int FloorId);


}
