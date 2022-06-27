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

import com.ty.Hospital.Dto.Facility;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FacilityController {
	@PostMapping("admin/{aid}/branch/{bid}/facillity")
	@ApiOperation("To Save facility By Admin")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save The facility Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/AdiminId"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Facility>> save(@RequestBody Facility facility, @PathVariable int aid,
			@PathVariable int bid) {
		return null;
	}

	@GetMapping("facility/{id}")
	@ApiOperation("To fetch facility By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Facility Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Fecility Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Facility>> getById(@PathVariable int id) {
		return null;
	}

	@GetMapping("facilities")
	@ApiOperation("To fetch All Facilities")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Fecilitys Successfully"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<Facility>>> getAll() {
		return null;
	}

	@PutMapping("admin/{aid}/branch/{bid}/building")
	@ApiOperation("To Update Facilities By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save/Update The Facilitys Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Fecility Id/Facility Id did not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Facility>> update(@RequestBody Facility facility, @PathVariable int fid,
			@PathVariable int aid) {
		return null;
	}

	@DeleteMapping("fecility/{id}")
	@ApiOperation("To Delete facility By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete The Facility Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Facility Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Facility>> delete(@RequestParam int id) {
		return null;
	}

}
