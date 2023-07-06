package com.example.cabinetdentistspring.services;


import com.example.cabinetdentistspring.models.Prescription;
import com.example.cabinetdentistspring.models.RendezVous;
import com.example.cabinetdentistspring.repos.RendezVousRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepos RendezVousRepo;


    public List<RendezVous> finaAllRendezVous(){
        return (List<RendezVous>) RendezVousRepo.findAll();
    }

    public RendezVous findRendezVousById(Integer id){
        return RendezVousRepo.findById(id).get();
    }

    public RendezVous addRendezVous(RendezVous RendezVous){
        return RendezVousRepo.save(RendezVous);
    }

    public RendezVous updateRendezVous(RendezVous RendezVous){
        return RendezVousRepo.save(RendezVous);
    }

    public void deleteRendezVousById(Integer id){
        RendezVousRepo.deleteById(id);
    }

    public int countRendezvous(){
        return RendezVousRepo.countRendezvous();
    }




}
