package com.ty.Hospital.Controller;

import java.util.List;

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
import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@PostMapping("admin/{aid}/hospital/{hid}/branch")
	@ApiOperation("To Save The Branch By AdminID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Admin/Hospital Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Branch>> save(@RequestBody Branch branch, @PathVariable @ApiParam("AdminID") int aid,
			@PathVariable @ApiParam("HospitalID") int hid) {
		return null;
	}

	@GetMapping("branch/{bid}")
	@ApiOperation("To Fetch The Branch By BranchID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branch Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Branch>> getById(@PathVariable @ApiParam("BranchID") int bid) {
		return null;
	}

	@GetMapping("branch")
	@ApiOperation("To Fetch The All Branch ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch All Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branches Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<Branch>>> getAll() {
		return null;
	}

	@PutMapping("admin/{aid}/branch")
	@ApiOperation("To Update The Branch By BranchID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save/Update Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branch Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Branch>> update(@RequestBody Building building, @PathVariable @ApiParam("BranchID") int bid,
			@PathVariable @ApiParam("AdminID")  int aid) {
		return null;
	}

	@DeleteMapping("branch")
	@ApiOperation("To Delete The Branch By BranchID")
	@ApiResponses({ @ApiResponse(code = 200, message = " Delete Branch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branch Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Branch>> delete(@RequestParam  @ApiParam("BranchID") int bid) {
		return null;
	}

}
