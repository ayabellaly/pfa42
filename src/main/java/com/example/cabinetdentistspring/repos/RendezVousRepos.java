package com.example.cabinetdentistspring.repos;

import com.example.cabinetdentistspring.models.Paiement;
import com.example.cabinetdentistspring.models.Prescription;
import com.example.cabinetdentistspring.models.RendezVous;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface RendezVousRepos extends CrudRepository<RendezVous,Integer> {


    @Query("SELECT p FROM RendezVous p WHERE p.patient.name = :patient")
    List<RendezVous> findRendezVousByPatient(String patient);
    @Query("SELECT count (r) FROM RendezVous r WHERE r.etat = 'PENDING'")
   public int  countRendezvous();
}
