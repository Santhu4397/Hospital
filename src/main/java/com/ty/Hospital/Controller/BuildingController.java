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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ty.Hospital.Dto.Branch;
import com.ty.Hospital.Dto.Building;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Service.BuildingService;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ListBean;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BuildingController {
	@Autowired
	BuildingService buildingService;
	@Autowired
	SequenceGeneratorService service;
	@PostMapping("branch/{bid}/building")
	@ApiOperation("To Save Building By Admin")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save The Building Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/AdiminId/Branch didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> save(@RequestBody Building building, @PathVariable @ApiParam("BranchID") int bid) {
		building.setId(service.generateBuildingSequence(Building.SEQUENCE_NAME));
		return buildingService.saveBuilding(building, bid);
	}

	@GetMapping("building/{bid}")
	@ApiOperation("To fetch Building By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Building Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branch Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospitalhelp>> getById(@PathVariable @ApiParam("BuildingId") int bid)  {
		return buildingService.getById(bid);
	}

	@GetMapping("branch/{branchId}/building")
	@ApiOperation("To fetch All Building ")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Building Successfully"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<ListBean>> getAll(@PathVariable int branchId) {
		return buildingService.getAllBuildingByBranch(branchId);
	}

	@PutMapping("admin/{aid}/branch/{bid}/building")
	@ApiOperation("To Update Building By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save/Update The Building Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branch Id/Admin Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> update(@RequestBody Building building,
			@PathVariable @ApiParam("BulidingID") int bid, @PathVariable @ApiParam("AdminID") int aid) {
		return buildingService.updatBuilding(bid, building);
	}

	@DeleteMapping("building/{id}")
	@ApiOperation("To Delete Building By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete The Building Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Branch Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Boolean>> delete(@RequestParam @ApiParam("BuildingID") int id) {
		return buildingService.deleteBuilding(id);
	}

}
