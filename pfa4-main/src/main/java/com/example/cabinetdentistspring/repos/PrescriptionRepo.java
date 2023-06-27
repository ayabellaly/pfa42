package com.example.cabinetdentistspring.repos;

import com.example.cabinetdentistspring.models.Prescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends CrudRepository<Prescription,Integer> {
}
