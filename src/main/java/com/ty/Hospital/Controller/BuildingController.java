package com.ty.Hospital.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital.Dto.Building;

@RestController
public class BuildingController {
	@PostMapping()
	public Building save() {
		return null;
	}

}
