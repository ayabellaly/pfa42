package com.example.cabinetdentistspring.services;

import com.example.cabinetdentistspring.models.Patient;
import com.example.cabinetdentistspring.repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public List<Patient> findallPatient() {
        return (List<Patient>) patientRepo.findAll();
    }

    public List<Patient> getPatientsByName(String name) {
        return patientRepo.findPatientByName(name);
    }



    public Patient findPatientById(Integer id) {
        Optional<Patient> result = patientRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return new Patient();
    }

    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }



    public Patient updatePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public void deleteById(Integer id) {
        patientRepo.deleteById(id);
    }



}
