package com.ty.Hospital.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Excipation.IdNotFound;
import com.ty.Hospital.Service.BuildingService;
import com.ty.Hospital.dao.BranchDao;
import com.ty.Hospital.dao.BuildingDao;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ListBean;
import com.ty.Hospital.util.ResponseStructure;
@Service
public class BuildingServiceimpl implements  BuildingService{

	@Autowired
	private BuildingDao buildingDao;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private HospitalDao hospitalDao;
	private ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
	@Override
	public ResponseEntity<ResponseStructure<Hospital>> saveBuilding(Building building, int branchid) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> entity = null;
		List<Building> Buildings = null;
		Hospital hospital = hospitalDao.getByBranchId(branchid);
		List<Branch> branchs = hospital.getBranchs();
		ListIterator<Branch> iterator=branchs.listIterator();
		while (iterator.hasNext()) {
			Branch branch=iterator.next();
			Buildings=branch.getBuildings();
			if(branch.getId()==branchid&&Buildings != null) {
				
				Buildings.add(building);
				branch.setBuildings(Buildings);
			}else if(branch.getId()==branchid&&Buildings==null){
				Buildings = new ArrayList<Building>();
				Buildings.add(building);
				branch.setBuildings(Buildings);
			}

			
			
		}
		
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(hospitalDao.updateHospitalById(hospital.getId(), hospital));
		structure.setMessage("Branch Saved Successfully");
		entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<ListBean>> getAllBuildingByBranch(int branchId) {
		ResponseStructure<ListBean> structure=new ResponseStructure<ListBean>();
		ResponseEntity<ResponseStructure<ListBean>> entity = null;
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("list of Building fetched");
		structure.setData(hospitalDao.getListOfBuildingByBranchId(branchId));
		entity= new  ResponseEntity<ResponseStructure<ListBean>>(structure, HttpStatus.OK);
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospitalhelp>> getById(int bid)  {
		ResponseStructure<Hospitalhelp> structure = new ResponseStructure<Hospitalhelp>();
		Hospitalhelp hospital=hospitalDao.getByBuildingId(bid);
		System.out.println(hospital.getBranchs());
		if(hospital!=null) {
			structure.setData(hospital);
			structure.setMessage("Building feached");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospitalhelp>>(structure, HttpStatus.OK);
		}
		throw new IdNotFound(bid+": building Id not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> updatBuilding(int bid, Building building) {
		Building exisitingBuilding=buildingDao.getBuildingById(bid);
		if(exisitingBuilding!=null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(null);
			structure.setMessage("building updated");
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
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
