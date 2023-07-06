package com.example.cabinetdentistspring.services;

import com.example.cabinetdentistspring.models.Paiement;
import com.example.cabinetdentistspring.models.Patient;
import com.example.cabinetdentistspring.models.Prescription;
import com.example.cabinetdentistspring.repos.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepo prescriptionRepo;



    public List<Prescription>finaAllPrescription(){
        return (List<Prescription>) prescriptionRepo.findAll();
    }

    public Prescription findPrescriptionById(Integer id){
        return prescriptionRepo.findById(id).get();
    }

    public Prescription addPrescription(Prescription prescription){
        return prescriptionRepo.save(prescription);
    }

    public Prescription updatePrescription(Prescription prescription){
        return prescriptionRepo.save(prescription);
    }

    public void deletePrescriptionById(Integer id){
        prescriptionRepo.deleteById(id);
    }

    public Prescription extractLineFromTable(Integer lineId) {

        Optional<Prescription> prescription = prescriptionRepo.findById(lineId);
        if (prescription.isPresent()) {
            return prescription.get();
        }
        return null;


    }

    public List<Prescription> searchPrescription(String patient) {
        return prescriptionRepo.findprescriptionByPatient(patient);
    }

    public long count (LocalDateTime dt) {
        return prescriptionRepo.count(dt);

    }






}
