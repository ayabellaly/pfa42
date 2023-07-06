package com.example.cabinetdentistspring.repos;

import com.example.cabinetdentistspring.models.Prescription;
import com.example.cabinetdentistspring.models.RendezVous;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface RendezVousRepos extends CrudRepository<RendezVous,Integer> {


    @Query("SELECT count (r) FROM RendezVous r WHERE r.etat = 'PENDING'")
   public int  countRendezvous();
}