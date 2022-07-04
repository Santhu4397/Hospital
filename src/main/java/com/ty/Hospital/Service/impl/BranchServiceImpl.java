package com.ty.Hospital.Service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Excipation.IdNotFound;
import com.ty.Hospital.Repo.BranchRepository;
import com.ty.Hospital.Service.BranchService;
import com.ty.Hospital.dao.BranchDao;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.util.ResponseStructure;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDao branchDao;

	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private BranchRepository branchRepository;

	@Override
	public ResponseEntity<ResponseStructure<Branch>> saveBranchByHospital(int hospitalId, Branch branch) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		ResponseEntity<ResponseStructure<Branch>> entity = null;
		List<Branch> branchs=new ArrayList<Branch>();
		branchs.add(branch);
		Hospital hospital=hospitalDao.getHospitalById(hospitalId);
		hospital.setBranchs(branchs);
		hospital.setGst("1234565");
		hospitalDao.updateHospitalById(hospitalId, hospital);
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(branchDao.saveBranchByHospital(hospitalId, branch));
		structure.setMessage("Branch Saved Successfully");
		entity = new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int branchId) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		ResponseEntity<ResponseStructure<Branch>> entity = null;
		Branch branch = branchDao.getBranchById(branchId);
		if (branch != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(branchDao.getBranchById(branchId));
			structure.setMessage("Branch Fetched Successfully");
			entity = new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound(branchId + "Branch Id Does Not Exist");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int branchId, Branch branch) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		ResponseEntity<ResponseStructure<Branch>> entity = null;
		Branch existingBranch = branchDao.updateBranchById(branchId, branch);
		if (existingBranch != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(branch);
			structure.setMessage("updated Success");
			entity = new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound(branchId + "BranchId Does Not Exist");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteBranchById(int branchId) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity = null;
		if(branchDao.deleteBranchById(branchId)) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData("Branch Deleted");
			structure.setMessage("Successfully");
			entity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
			return entity;
		}else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(branchId + "Branch Id Does Not Found");
			structure.setMessage("No Branches Deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
			return entity;
		}
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospitalId(int hospitalId) {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<List<Branch>>();
		ResponseEntity<ResponseStructure<List<Branch>>> entity = null;
//		Hospital hospital = hospitalDao.getHospitalById(hospitalId);
//		List<Branch> branchs = hospital.getBranchs();
//		
//		if (branchs != null) {
//			structure.setStatusCode(HttpStatus.OK.value());
//			structure.setData(branchs);
//			structure.setMessage("All Branches Fetched successfully");
//			entity = new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
//		} else {
//			throw new IdNotFound(hospitalId + "HospitalId Not Does Not found");
//		}
//		List<Branch> branchs=branchRepository.findAll();
//		List<Branch> hospitalBranchs=branchs.stream().filter((b)->b.getHospital().getId()==hospitalId).toList();
//		structure.setStatusCode(HttpStatus.OK.value());
//		structure.setData(hospitalBranchs);
//		structure.setMessage("All Branches Fetched successfully");
//		entity = new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);

		
		return entity;
	}

}
