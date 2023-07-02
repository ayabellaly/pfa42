package com.example.cabinetdentistspring.repos;


import com.example.cabinetdentistspring.models.Paiement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;






@Repository
public interface PaiementRepo extends CrudRepository<Paiement, Integer> {


}
