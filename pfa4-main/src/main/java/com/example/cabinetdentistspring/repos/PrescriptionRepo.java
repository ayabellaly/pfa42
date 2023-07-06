package com.example.cabinetdentistspring.repos;

import com.example.cabinetdentistspring.models.Paiement;
import com.example.cabinetdentistspring.models.Prescription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PrescriptionRepo extends CrudRepository<Prescription,Integer> {


    @Query("SELECT p FROM Prescription p WHERE p.patient.name = :patient")
    List<Prescription> findprescriptionByPatient(String patient);


    @Query("SELECT COUNT(p ) FROM  Prescription p where Date(p.prescribedDate) = Date(:dt)  ")
    public long count(LocalDateTime dt) ;

}
