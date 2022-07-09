package com.ty.Hospital.Service.impl;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Service.FloorService;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.util.ResponseStructure;

@Service
public class FloorServiceImpl implements FloorService {
	
	@Autowired
	private HospitalDao hospitalDao;

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> saveFloorByBuilding(int buildingId, Floor floor) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> entity = null;
	/*	List<Floor> floors = null;
		 hospitalDao.getBranchByBuildingId(buildingId);
		Building iterator=branchs.get(buildingId);
		while(iterator.hasNext()) {
			Branch branch = iterator.next();
		}
		return null;
	}*/
return null;
}
}
