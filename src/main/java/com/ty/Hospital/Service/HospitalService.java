package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.util.ResponseStructure;

public interface HospitalService {
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital,int uid);
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital();
	public ResponseEntity<ResponseStructure<Hospital>> getById(int hid);
	public ResponseEntity<ResponseStructure<Hospital>> updatHospital(int hid,Hospital hospital);
	public ResponseEntity<ResponseStructure<Boolean>> deleteHospital(int hid);

}
