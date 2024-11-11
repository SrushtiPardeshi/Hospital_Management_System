package com.nt.service;

import com.nt.entity.Patient;

public interface IPatientService {
	
	public Iterable<Patient> showAllPatientsRecord();
	
	public String addPatientData(Patient pat);
	
	public Patient fetchPatientById(int pid);
	
	public String ModifyPatientRecord(Patient pat);
	
	public String deletePatientById(int id);
	
	

}
