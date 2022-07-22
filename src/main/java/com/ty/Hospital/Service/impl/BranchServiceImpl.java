package com.ty.Hospital.Service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
import com.ty.Hospital.util.ListBean;
import com.ty.Hospital.util.ResponseStructure;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private HospitalDao hospitalDao;

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> saveBranchByHospital(int hospitalId, Branch branch) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> entity = null;
		List<Branch> branchs = null;
		Hospital hospital = hospitalDao.getHospitalById(hospitalId);
		branchs = hospital.getBranchs();
		if (branchs != null) {
			branchs.add(branch);
			hospital.setBranchs(branchs);
		} else {
			branchs = new ArrayList<Branch>();
			branchs.add(branch);
			hospital.setBranchs(branchs);
		}

		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(hospitalDao.updateHospitalById(hospitalId, hospital));
		structure.setMessage("Branch Saved Successfully");
		entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> getBranchById(int branchId) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> entity = null;
		Hospital searchedHospital = hospitalDao.getByBranchId(branchId);
		if (searchedHospital != null) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(searchedHospital);
			structure.setMessage("Branch Fetched Successfully");
			entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound(branchId + "Branch Id Does Not Exist");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> updateBranchById(int hid, int branchId, Branch branch) {
		ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> entity = null;
		Hospital hospital = hospitalDao.getByBranchId(branchId);
		List<Branch> existingBranchs = hospital.getBranchs();
		if (existingBranchs != null) {
			ListIterator<Branch> iterator = existingBranchs.listIterator();
			while (iterator.hasNext()) {
				Branch existingBranch = iterator.next();
				if (existingBranch.getId() == branchId) {
					existingBranch.setBranch_Name(branch.getBranch_Name());
					existingBranch.setBranch_Number(branch.getBranch_Number());
					existingBranch.setCity(branch.getCity());
					existingBranch.setCountry(branch.getCountry());
					existingBranch.setState(branch.getState());
					existingBranch.setPincode(branch.getPincode());
					structure.setStatusCode(HttpStatus.OK.value());
					structure.setData(hospitalDao.saveHospital(hospital, 0));
					structure.setMessage("updated Success");
				}

			}

			entity = new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound(branchId + "BranchId Does Not Exist");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteBranchById(int hid, int branchId) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity = null;
		Hospital hospital = hospitalDao.getHospitalById(hid);
		if (hospital != null) {
			List<Branch> branchs = hospital.getBranchs();
			ListIterator<Branch> iterator = branchs.listIterator();
			while (iterator.hasNext()) {
				Branch branch = iterator.next();
				if (branch.getId() == branchId) {
					iterator.remove();
					hospitalDao.updateHospitalById(hid, hospital);
					structure.setStatusCode(HttpStatus.OK.value());
					structure.setData("Branch Deleted");
					structure.setMessage("Successfully");
					System.out.println("if");
				} else {
					structure.setStatusCode(HttpStatus.NOT_FOUND.value());
					structure.setData(branchId + "Branch Id Does Not Found");
					structure.setMessage("No Branches Deleted");
					System.out.println("else");
				}
				hospital.setBranchs(branchs);
			}

			entity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
			return entity;
		} else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(hid + " Hospital Id Does Not Found");
			structure.setMessage("No Branches Deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
			return entity;
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<ListBean>> getAllBranchByHospitalId(int hospitalId) {
		ResponseStructure<ListBean> structure = new ResponseStructure<ListBean>();
		ResponseEntity<ResponseStructure<ListBean>> entity = null;
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(hospitalDao.getListOfBranchesByHospitalId(hospitalId));
		structure.setMessage("All Branches Fetched successfully");
		Hospital hospital = hospitalDao.getHospitalById(hospitalId);
		entity = new ResponseEntity<ResponseStructure<ListBean>>(structure, HttpStatus.OK);
		return entity;
	}

}
