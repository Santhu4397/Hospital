package com.ty.Hospital.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.Dto.Branch;

@RestController
public class BranchController {
	
	@PostMapping("branch")
	public Branch saveBranch() {
		return null;
	}
}
