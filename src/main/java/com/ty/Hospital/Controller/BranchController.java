package com.ty.Hospital.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Branch_Sequences;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Service.BranchService;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.dao.HospitalDao;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	public BranchService branchService;
	
	@Autowired
	public SequenceGeneratorService generatorService;


	@PostMapping("/hospital/{hid}/branch")
	@ApiOperation("To Save The Branch By AdminID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Admin/Hospital Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> save(@RequestBody Branch branch,
			@PathVariable @ApiParam("HospitalID") int hid) {
		branch.setId(generatorService.generateBranchSequence(Branch.SEQUENCE_NAME));
		return branchService.saveBranchByHospital(hid, branch);
	}

	@GetMapping("hospital/{hid}/branch/{bid}")
	@ApiOperation("To Fetch The Branch By BranchID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branch Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> getById(@PathVariable @ApiParam("BranchID") int bid) {
		return branchService.getBranchById(bid);
	}

	@GetMapping("hospital/{hid}/branch")
	@ApiOperation("To Fetch The All Branch ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch All Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branches Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<Branch>>> getAll(@PathVariable @ApiParam("HospitalID") int hid) {
		return branchService.getAllBranchByHospitalId(hid);
	}

	@PutMapping("/hospital/{hid}/branch/{bid}")
	@ApiOperation("To Update The Branch By BranchID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save/Update Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branch Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> update(@RequestBody Branch branch,@PathVariable int hid,
			@PathVariable @ApiParam("BranchID") int bid) {
		return branchService.updateBranchById(hid,bid, branch);
	}

	@DeleteMapping("hospital/{hid}/branch/{bid}")
	@ApiOperation("To Delete The Branch By BranchID")
	@ApiResponses({ @ApiResponse(code = 200, message = " Delete Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branch Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable @ApiParam("BranchID") int bid,@PathVariable int hid) {
		return branchService.deleteBranchById(hid,bid);
	}

}
