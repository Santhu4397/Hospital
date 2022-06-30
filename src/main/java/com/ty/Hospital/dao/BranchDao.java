package com.ty.Hospital.dao;

import java.util.List;

import com.ty.Hospital.Dto.Branch;

public interface BranchDao {

	public Branch saveBranchByHospital(int hospitalID, Branch branch);

	public Branch getBranchById(int branchId);

	public List<Branch> getAllBranchByHospital(int hospitalId);

	public Branch updateBranchById(int branchId, Branch branch);

	public boolean deleteBranchById(int branchId);

}
