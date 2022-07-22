package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ListBean;
import com.ty.Hospital.util.ResponseStructure;

public interface BuildingService {
	public ResponseEntity<ResponseStructure<Hospital>> saveBuilding(Building building,int bid);
	public ResponseEntity<ResponseStructure<ListBean>> getAllBuildingByBranch(int branchId);
	public ResponseEntity<ResponseStructure<Hospitalhelp>> getById(int bid) ;
	public ResponseEntity<ResponseStructure<Hospital>> updatBuilding(int bid,Building building);
	public ResponseEntity<ResponseStructure<Boolean>> deleteBuilding(int bid);


}
