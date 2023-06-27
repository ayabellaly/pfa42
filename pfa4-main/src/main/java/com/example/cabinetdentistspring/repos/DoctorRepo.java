package com.example.cabinetdentistspring.repos;

import com.example.cabinetdentistspring.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
}
