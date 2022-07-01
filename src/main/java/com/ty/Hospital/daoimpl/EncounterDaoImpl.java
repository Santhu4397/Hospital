package com.ty.Hospital.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.Dto.Bed;
import com.ty.Hospital.Dto.Encounter;
import com.ty.Hospital.Repo.BedRepository;
import com.ty.Hospital.Repo.EncounterRepository;
import com.ty.Hospital.dao.EncounterDao;
@Repository
public class EncounterDaoImpl implements EncounterDao {

	@Autowired
	public EncounterRepository encounterRepository;

	@Autowired
	BedRepository bedRepository;

	@Override
	public Encounter saveEncounter(Encounter encounter, int bedId) {
		Bed bed = bedRepository.getBedById(bedId);
		encounter.setBed(bed);
		return encounterRepository.save(encounter);
	}

	@Override
	public Encounter getEncounterById(int encounterId) {
		Optional<Encounter> optional = encounterRepository.findById(encounterId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	@Override
	public List<Encounter> getAllEncounterByBedId(int bedId) {
		Bed bed = bedRepository.getBedById(bedId);
		return bed.getEncounters();
	}

	@Override
	public Encounter updateEncounterById(int encounterId, Encounter encounter) {
		Encounter existingEncounter = getEncounterById(encounterId);
		if (existingEncounter != null) {
			existingEncounter.setCreaterName(encounter.getCreaterName());
			existingEncounter.setDateOfAdmit(encounter.getDateOfAdmit());
			existingEncounter.setReason(encounter.getReason());
			Bed bed = bedRepository.getBedById(encounter.getBed().getId());
			if (bed != null) {
				existingEncounter.setBed(encounter.getBed());
			}
			return encounterRepository.save(existingEncounter);
		}
		return null;
	}

	@Override
	public boolean deleteEncounterById(int encounterId) {
		Encounter encounter = getEncounterById(encounterId);
		if (encounter != null) {
			encounterRepository.delete(encounter);
			return true;
		}
		return false;
	}

}
