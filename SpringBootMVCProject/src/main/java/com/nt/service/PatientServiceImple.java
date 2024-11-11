package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Patient;
import com.nt.repository.IPatientRepository;

@Service
public class PatientServiceImple implements IPatientService {

	@Autowired
	private IPatientRepository patRepo;
	
	@Override
	public Iterable<Patient> showAllPatientsRecord() {
		// TODO Auto-generated method stub
		return patRepo.findAll();
	}

	@Override
	public String addPatientData(Patient pat) {
		int pid=patRepo.save(pat).getPid();
		return "add Patient Data with id Value::"+pid;
	}
	
	@Override
	public Patient fetchPatientById(int pid) {
		
		return patRepo.findById(pid).orElseThrow(()->new IllegalArgumentException("Invalid Number"));
	}
	
	@Override
	public String ModifyPatientRecord(Patient pat) {
		Optional<Patient> opt=patRepo.findById(pat.getPid());
		if(opt.isPresent()) {
			patRepo.save(pat);
			return pat.getPid()+" is updated";
		}
		return pat.getPid()+"Not Found For Updation";
	}
	
	@Override
	public String deletePatientById(int id) {
		Optional<Patient> opt=patRepo.findById(id);
		if(opt.isPresent()) {
			patRepo.deleteById(id);
			return id+" is Deleted";
		}
		return id+"Not Found For deletion";
	}
}
