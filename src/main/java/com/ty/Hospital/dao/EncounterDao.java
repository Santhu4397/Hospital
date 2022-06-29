package com.ty.Hospital.dao;

import com.ty.Hospital.Dto.Encounter;

public interface EncounterDao {

	public Encounter saveEncounter(Encounter encounter, int bedId);

	public Encounter getEncounterById(int encounterId);

	public Encounter getAllEncounterByBedId(int bedId);

	public Encounter updateEncounterById(int encounterId, Encounter encounter);

	public boolean deleteEncounterById(int encounterId);

}
