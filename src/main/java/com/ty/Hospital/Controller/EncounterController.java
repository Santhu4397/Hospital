package com.ty.Hospital.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.Dto.Encounter;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {

	@PostMapping("bed/{bid}/encounter")
	@ApiOperation("To Save Encounter By BedID")
	@ApiResponses({ @ApiResponse(code = 200, message = "saved Encounter Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/BedId Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounterByBedId(@RequestBody Encounter encounter,
			@PathVariable @ApiParam("BedId") int bid) {
		return null;
	}

	@GetMapping("bed/{bid}/encounter/{eid}")
	@ApiOperation("To Get Encounter By EncounterID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch Encounter Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/EncounterID Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(
			@PathVariable @ApiParam("EncounterID") int eid) {
		return null;
	}

	@GetMapping("bed/{bid}/encounter")
	@ApiOperation("To Get All Encounter By BedID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch Encounter Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/BedID Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<Encounter>>> getAllEncounterByBedId(
			@PathVariable @ApiParam("BedIDID") int bid) {
		return null;
	}

	@PutMapping("bed/{bid}/encounter/{eid}")
	@ApiOperation("To Save/update Encounter By EncounterID")
	@ApiResponses({ @ApiResponse(code = 200, message = "save/update Encounter Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/EncounterId Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter,
			@PathVariable @ApiParam("EncounterID") int eid) {
		return null;
	}
	
	@DeleteMapping("bed/{bid}/encounter/{eid}")
	@ApiOperation("To Delete Encounter By BedID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete Encounter Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/EncounterId Did Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<String>> deleteEncounter(@PathVariable @ApiParam("EncounterID") int eid){
		return null;
	}
}
