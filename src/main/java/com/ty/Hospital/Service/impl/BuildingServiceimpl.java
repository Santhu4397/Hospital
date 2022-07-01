package com.ty.Hospital.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Excipation.IdNotFound;
import com.ty.Hospital.Service.BuildingService;
import com.ty.Hospital.dao.BranchDao;
import com.ty.Hospital.dao.BuildingDao;
import com.ty.Hospital.util.ResponseStructure;
@Service
public class BuildingServiceimpl implements  BuildingService{

	@Autowired
	private BuildingDao buildingDao;
	@Autowired
	private BranchDao branchDao;
	private ResponseStructure<Building> structure=new ResponseStructure<Building>();
	@Override
	public ResponseEntity<ResponseStructure<Building>> saveBuilding(Building building, int bid) {
		Branch branch=branchDao.getBranchById(bid);
		building.setBranch(branch);
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("building saved");
		structure.setData(buildingDao.saveBuilding(building, bid));
		return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Building>>> getAllBuilding() {
		ResponseStructure<List<Building>> structure=new ResponseStructure<List<Building>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("list of Building");
		structure.setData(buildingDao.getAllBuildings());
		return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Building>> getById(int bid) {
		Building building=buildingDao.getBuildingById(bid);
		
		if(building!=null) {
			structure.setData(building);
			structure.setMessage("Building feached");
			structure.setStatusCode(HttpStatus.OK.value());
		}
		throw new IdNotFound(bid+": building Id not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<Building>> updatBuilding(int bid, Building building) {
		Building exisitingBuilding=buildingDao.getBuildingById(bid);
		if(exisitingBuilding!=null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(buildingDao.updateBuilding(exisitingBuilding, bid));
			structure.setMessage("building updated");
			return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.OK);
		}
		throw new IdNotFound(bid+": building Id not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<Boolean>> deleteBuilding(int bid) {
		Building building=buildingDao.getBuildingById(bid);
		
		if(building!=null) {
			ResponseStructure<Boolean> structure=new ResponseStructure<Boolean>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(buildingDao.deleteBuildingById(bid));
			structure.setMessage("building deleted");
			return new ResponseEntity<ResponseStructure<Boolean>>(structure, HttpStatus.OK);
		}
		 throw new IdNotFound(bid+"hospital id not found");
		
	}

}
