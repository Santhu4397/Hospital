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

import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.Dto.Room;
import com.ty.Hospital.Service.RoomService;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class RoomController {
	@Autowired
	RoomService roomService;
	@Autowired
	SequenceGeneratorService service;
	
	@PostMapping("admin/{aid}/floor/{fid}/room")
	@ApiOperation("To Save Room By Admin")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save The Room Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/AdiminId/Floor Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospital>> save(@RequestBody Room room, @PathVariable int aid,
			@PathVariable int fid) {
		room.setId(service.generateRoomSequence(Room.SEQUENCE_NAME) );
		return roomService.saveRoom(room, fid);
	}

	@GetMapping("room/{rid}")
	@ApiOperation("To fetch Building By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Room Successfully"),
			@ApiResponse(code = 400, message = "Bad Request Floor Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Hospitalhelp>> getById(@PathVariable int rid) {
		return roomService.getRoomById(rid);
	}

	@GetMapping("room")
	@ApiOperation("To fetch All Building ")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetch The Room Successfully"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<Room>>> getAll() {
		return null;
	}

	@PutMapping("admin/{aid}/floor/{fid}/room")
	@ApiOperation("To Update Building By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save/Update The Room Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Floor Id/Admin Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Room>> update(@RequestBody Room room, @PathVariable int fid,
			@PathVariable int aid) {
		return null;
	}

	@DeleteMapping("room/{id}")
	@ApiOperation("To Delete Building By Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete The Room Successfully"),
			@ApiResponse(code = 400, message = "Bad Request/Room Id didnot Found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<Room>> delete(@RequestParam int id) {
		return null;
	}

}
