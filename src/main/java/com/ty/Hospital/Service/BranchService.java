package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.util.ResponseStructure;

public interface BranchService {

	public ResponseEntity<ResponseStructure<Branch>> saveBranchByHospital(int hospitalId, Branch branch);

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int branchId);

	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranchByHospitalId(int hospitalId);

	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int branchId, Branch branch);

	public ResponseEntity<ResponseStructure<String>> deleteBranchById(int branchId);

}
