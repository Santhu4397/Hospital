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
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Dto.Floor_Sequences;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Service.FloorService;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FloorController {
	@Autowired
	FloorService floorService;
	@Autowired
	SequenceGeneratorService generatorService;

	@PostMapping("Building/{bid}/floor")
	@ApiOperation("To Save Floor By Building")
	@ApiResponses({ @ApiResponse(code = 200, message = "Floor Saved Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/BuildingID Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> saveFloor(@RequestBody Floor floor,
			@PathVariable @ApiParam("BuiledingID") int bid) {
		floor.setId(generatorService.generateFloorSequence(Floor.SEQUENCE_NAME));
		return  floorService.saveFloor(floor, bid);
	}

	@GetMapping("Building/{bid}/floor/{fid}")
	@ApiOperation("To Fetch Floor By FloorID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Floor Fetch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/BuildingID/FloorID Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospitalhelp>> getFloorByID(@PathVariable @ApiParam("FloorID") int fid) {
		return floorService.getFloorById(fid);
	}

	@GetMapping("Building/{buildingId}/floor")
	@ApiOperation("To All Fetch Floor By Building")
	@ApiResponses({ @ApiResponse(code = 200, message = "Floor Fetch Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Floor Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<Floor>>> getAllFloor(@PathVariable int buildingId ) {
		return floorService.getAllFloor(buildingId);
	}

	@PutMapping("Building/{bid}/floor/{fid}")
	@ApiOperation("To Update Floor By FloorID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Floor Updated Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/BuildingID/FloorID Not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> updateFloorByID(@PathVariable @ApiParam("FloorID") int fid,
			@RequestBody Floor floor) {
		return floorService.updateFloor(floor, fid);
	}
	
	@DeleteMapping("Building/{bid}/floor/{fid}")
	@ApiOperation("To Delete The Floor By ID")
	@ApiResponses({@ApiResponse(code = 200, message = "FLoor Deleted Successfully"),
		@ApiResponse(code = 400, message = "Bad Request/BuildingID/FloorID Not Found"),
		@ApiResponse(code = 500, message = "internal server error")})
	public ResponseEntity<ResponseStructure<String>> DeleteFoorById(@PathVariable @ApiParam("FloorID") int fid){
		return floorService.deleteFloorById(fid);
	}
}
