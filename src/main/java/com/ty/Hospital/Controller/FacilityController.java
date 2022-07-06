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

import com.ty.Hospital.Dto.Facility;
import com.ty.Hospital.Service.FacilityService;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FacilityController {

	@Autowired
	private FacilityService service2;
	
	@Autowired
	private SequenceGeneratorService service;

	@PostMapping("branch/{branchId}/facility")
	@ApiOperation("To Save facility By BranchId")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save The facility Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/BranchId"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Facility>> save(@RequestBody Facility facility,
			@PathVariable @ApiParam("BranchID") int branchId) {
		facility.setId(service.generateFacilitySequence(Facility.SEQUENCE_NAME));
		return service2.saveFacility(facility, branchId) ;
	}

	@GetMapping("facility/{facilityId}")
	@ApiOperation("To fetch facility By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Facility Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Fecility Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Facility>> getById(@PathVariable @ApiParam("FacilityID") int facilityId) {
		return service2.getFacilityById(facilityId);
	}

	@GetMapping("facility")
	@ApiOperation("To fetch All Facilities")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Fecilitys Successfully"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<Facility>>> getAll() {
		return service2.getAllFacilitys();
	}

	@PutMapping("facility/{facilityId}/facility")
	@ApiOperation("To Update Facilities By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save/Update The Facilitys Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Fecility Id/Facility Id did not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Facility>> update(@RequestBody Facility facility,
			@PathVariable @ApiParam("FacilityID") int facilityId) {
		return service2.updateFacility(facility, facilityId);
	}

	@DeleteMapping("facility/{facilityId}")
	@ApiOperation("To Delete facility By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete The Facility Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Facility Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Boolean>> delete(@RequestParam @ApiParam("FacilityID") int facilityId) {
		return service2.deleteFacilityById(facilityId);
	}

}
