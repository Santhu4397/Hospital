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

import com.ty.Hospital.Dto.Bed;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Service.BedService;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BedController {
	@Autowired
	BedService bedService;
	@Autowired
	SequenceGeneratorService generatorService;
	@PostMapping("room/{roomid}/bed")
	@ApiOperation("To Save bed By Admin")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save The bed Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/HospitalId"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> save(@RequestBody Bed bed,
			@PathVariable int roomid) {
		bed.setId(generatorService.generateBedSequence(Bed.SEQUENCE_NAME));
		return bedService.saveBed(bed, roomid) ;
	}

	@GetMapping("bed/{id}")
	@ApiOperation("To fetch Bed By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Bed Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Bed Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Bed>> getById(@PathVariable int id) {
		return null;
	}

	@GetMapping("bed")
	@ApiOperation("To fetch All beds")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Beds Successfully"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<Bed>>> getAll() {
		return null;
	}

	@PutMapping("hospital/{hid}/branch/{bid}/bed")
	@ApiOperation("To Update Bed By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save/Update The Bed Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Bed Id/Bed Id did not Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Bed>> update(@RequestBody Bed bed, @PathVariable int hid,
			@PathVariable int bid) {
		return null;
	}

	@DeleteMapping("bed/{id}")
	@ApiOperation("To Delete bed By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete The Bed Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Bed Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Bed>> delete(@RequestParam int id) {
		return null;
	}

}
