package com.example.cabinetdentistspring.repos;


import com.example.cabinetdentistspring.models.Paiement;
import com.example.cabinetdentistspring.models.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaiementRepo extends CrudRepository<Paiement, Integer> {


    @Query("SELECT p FROM Paiement p WHERE p.patient.name = :patient")
    List<Paiement> findPaiementByPatient(String patient);

}
