package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.util.ResponseStructure;

public interface BuildingService {
	public ResponseEntity<ResponseStructure<Building>> saveBuilding(Building building,int bid);
	public ResponseEntity<ResponseStructure<List<Building>>> getAllBuilding();
	public ResponseEntity<ResponseStructure<Building>> getById(int bid);
	public ResponseEntity<ResponseStructure<Building>> updatBuilding(int bid,Building building);
	public ResponseEntity<ResponseStructure<Boolean>> deleteBuilding(int bid);


}
