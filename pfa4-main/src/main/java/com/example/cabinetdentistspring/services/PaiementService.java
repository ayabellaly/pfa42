package com.example.cabinetdentistspring.services;

import com.example.cabinetdentistspring.models.Paiement;
import com.example.cabinetdentistspring.models.Patient;
import com.example.cabinetdentistspring.repos.PaiementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {


    @Autowired
    private PaiementRepo paiementRepo;



    public List<Paiement> findallPaiement() {
        return (List<Paiement>) paiementRepo.findAll();
    }

    public Paiement findPaiementById(Integer id) {
        return paiementRepo.findById(id).get();
    }

    public Paiement addPaiement(Paiement paiement) {
        return paiementRepo.save(paiement);
    }

    public Paiement updatePaiement(Paiement paiement) {
        return paiementRepo.save(paiement);
    }

    public void deleteById(Integer id) {
        paiementRepo.deleteById(id);
    }


   public List<Paiement> searchPaiementBYpatientName (String name){
        return paiementRepo.searchPaiementBYpatientName(name);
   }

}
