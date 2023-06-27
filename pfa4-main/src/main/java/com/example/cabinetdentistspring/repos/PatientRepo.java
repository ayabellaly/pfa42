package com.example.cabinetdentistspring.repos;

import com.example.cabinetdentistspring.models.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends CrudRepository<Patient, Integer> {


    @Query("SELECT p FROM Patient p WHERE p.name = :name")
    List<Patient> findPatientByName(@Param("name") String name);
}
