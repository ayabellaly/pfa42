package com.example.cabinetdentistspring.controller;

import com.example.cabinetdentistspring.models.Paiement;
import com.example.cabinetdentistspring.models.Patient;
import com.example.cabinetdentistspring.repos.PatientRepo;
import com.example.cabinetdentistspring.services.PaiementService;
import com.example.cabinetdentistspring.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class PaiementController {


    @Autowired
    private PaiementService paiementService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepo patientRepo;


    @GetMapping("/allPaiement")
    public String findAll(Model model) {
        model.addAttribute("paiement", paiementService.findallPaiement());
        return "paiement";
    }


    @GetMapping("/addP")
    public String AddPaiement(Model model) {
        model.addAttribute("paiement", new Paiement());
        model.addAttribute("patients", patientService.findallPatient());
        return "add-Paiement";
    }

    @PostMapping("/addPaiement")
    public String createPaiement(Paiement paiement, @RequestParam("dateZ") String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date datePaiement = dateFormat.parse(date);
        paiement.setDatePaiement(datePaiement);
        System.out.println(datePaiement);
        paiementService.addPaiement(paiement);
        return "redirect:/allPaiement";
    }

    @GetMapping("/Paiement/edit/{id}")
    public String lunchEditPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("paiement", paiementService.findPaiementById(id));
        model.addAttribute("patients", patientService.findallPatient());
        return "edit-Paiement";

    }


    @PostMapping("/updatePaiement")
    public String upadtePaiement(Paiement paiement, @RequestParam("dateZ") String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date datePaiement = dateFormat.parse(date);
        paiement.setDatePaiement(datePaiement);
        paiementService.updatePaiement(paiement);
        return "redirect:/allPaiement";
    }

    @GetMapping("/Paiement/delete/{id}")
    public String deletePaiement(@PathVariable("id") int id) {
        paiementService.deleteById(id);
        return "redirect:/allPaiement";



    }

    @PostMapping("/searchPaiement")
    public String searchPaiement(Model model, @RequestParam("name") String patient) {
        List<Paiement> paiements = paiementService.searchByPatient(patient);
        model.addAttribute("paiement", paiements);
        return "paiement";
    }


}