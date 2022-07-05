package com.ty.Hospital.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Repo.BranchRepository;
import com.ty.Hospital.dao.BranchDao;
import com.ty.Hospital.dao.HospitalDao;
@Repository
public class BranchDaoImpl implements BranchDao {

	@Autowired
	public BranchRepository branchRepository;

	@Autowired
	public HospitalDao hospitalDao;

	@Override
	public Branch saveBranchByHospital(int hospitalID, Branch branch) {
		Hospital hospital = hospitalDao.getHospitalById(hospitalID);
		//branch.setHospital(hospital);
		//return branchRepository.save(branch);
		return null;
	}

	@Override
	public Branch getBranchById(int branchId) {
		Optional<Branch> branch = branchRepository.findById(branchId);
		if (branch.isPresent()) {
			return branch.get();
		}
		return null;
	}

	@Override
	public List<Branch> getAllBranchByHospital(int hospitalId) {
		Hospital hospital = hospitalDao.getHospitalById(hospitalId);
		return hospital.getBranchs();
	}

	@Override
	public Branch updateBranchById(int branchId, Branch branch) {
		Branch existingBranch = getBranchById(branchId);
		if (existingBranch != null) {
			existingBranch.setBranch_Name(branch.getBranch_Name());
			existingBranch.setBranch_Number(branch.getBranch_Number());
			existingBranch.setCity(branch.getCity());
			existingBranch.setCountry(branch.getCountry());
			existingBranch.setState(branch.getState());
			existingBranch.setPincode(branch.getPincode());
			return branchRepository.save(existingBranch);
		}
		return null;
	}

	@Override
	public boolean deleteBranchById(int branchId) {
		Branch branch = getBranchById(branchId);
		if (branch != null) {
			branchRepository.delete(branch);
			return true;
		}
		return false;
	}

}
