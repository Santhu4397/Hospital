package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.util.ListBean;
import com.ty.Hospital.util.ResponseStructure;

public interface BranchService {

	public ResponseEntity<ResponseStructure<Hospital>> saveBranchByHospital(int hospitalId, Branch branch);

	public ResponseEntity<ResponseStructure<Hospital>> getBranchById(int branchId);

	public ResponseEntity<ResponseStructure<ListBean>> getAllBranchByHospitalId(int hospitalId);

	public ResponseEntity<ResponseStructure<Hospital>> updateBranchById(int hid,int branchId, Branch branch);

	public ResponseEntity<ResponseStructure<String>> deleteBranchById(int hid,int branchId);

}
