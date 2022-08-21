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

import com.ty.Hospital.Dto.LoginCredinstials;
import com.ty.Hospital.Dto.User;
import com.ty.Hospital.Repo.UserRepo;
import com.ty.Hospital.Service.SequenceGeneratorService;
import com.ty.Hospital.Service.UserService;
import com.ty.Hospital.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	@Autowired
	UserRepo repo;
	@Autowired
	SequenceGeneratorService service;

	@Autowired
	public UserService userService;

	@PostMapping("userlogin")
	@ApiOperation("To login into webservices ")
	@ApiResponses({ @ApiResponse(code = 200, message = "User Login Successfully"),
			@ApiResponse(code = 400, message = "bad request for UserData"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<User>> userLogin(@RequestBody LoginCredinstials credinstials) {
		return userService.loginUser(credinstials);
	}

	@PostMapping("user")
	@ApiOperation("To Save The User Data ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save User Data Successfully"),
			@ApiResponse(code = 400, message = "bad request for UserData"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		user.setId(service.generateSequence(User.SEQUENCE_NAME));
		return userService.saveUser(user);
	}

	@GetMapping("user/uid/{id}")
	@ApiOperation("To Fetch The User Data By Id ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetching User Data Successfully"),
			@ApiResponse(code = 400, message = "Id did not found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<User>> getByID(@PathVariable @ApiParam("AdminID") int id) {
		return userService.getuserById(id);
	}

	@GetMapping("user")
	@ApiOperation("To fetch The All User Data ")
	@ApiResponses({ @ApiResponse(code = 200, message = "fetching all User Data Successfully"),
			@ApiResponse(code = 400, message = "bad request for UserData"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<List<User>>> getAll() {
		return userService.getAllUser();
	}

	@PutMapping("user/admin/{aid}")
	@ApiOperation("To Update The User Data ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Save/update User Data Successfully"),
			@ApiResponse(code = 400, message = "bad request for UserData/userId not found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<User>> update(@RequestBody User user,
			@PathVariable @ApiParam("AdminID") int aid) {
		return userService.updateUserById(aid, user);
	}

	@DeleteMapping("user")
	@ApiOperation("To Delete The User Data By Id ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete User Data Successfully"),
			@ApiResponse(code = 400, message = "bad request for UserData/userId not found"),
			@ApiResponse(code = 500, message = "internal server error") })
	public ResponseEntity<ResponseStructure<String>> deleteById(@RequestParam @ApiParam("AdminID") int id) {
		return userService.deleteUserById(id);
	}
	

}
