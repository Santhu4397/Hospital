package com.ty.Hospital.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.Hospital.Dto.Bed;
import com.ty.Hospital.Dto.Floor;
import com.ty.Hospital.Dto.Hospital;
import com.ty.Hospital.util.Hospitalhelp;
import com.ty.Hospital.util.ResponseStructure;

public interface BedService {
	public ResponseEntity<ResponseStructure<Hospital>> saveBed(Bed bed, int roomId);

	public ResponseEntity<ResponseStructure<Hospitalhelp>> getBedById(int bedId);

	public ResponseEntity<ResponseStructure<List<Floor>>> getAllBed();

	public ResponseEntity<ResponseStructure<Hospital>> updateBed(Bed bed, int bedId);

	public ResponseEntity<ResponseStructure<String>> deleteBedById(int bedId);
}
