package com.ty.Hospital.Excipation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.Hospital.util.ResponseStructure;

@ControllerAdvice
public class ExcipationHandeler {
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ResponseStructure<String>> handler(Exception exception){
//		ResponseStructure< String> structure=new ResponseStructure<String>();
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		structure.setMessage(exception.getMessage());
//		structure.setData(null);
//		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
//	}

}
