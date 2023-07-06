package com.example.cabinetdentistspring.controller;


import com.example.cabinetdentistspring.models.Paiement;
import com.example.cabinetdentistspring.models.RendezVous;
import com.example.cabinetdentistspring.services.PatientService;
import com.example.cabinetdentistspring.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller

public class RendezVousController {


    @Autowired
    RendezVousService RendezVousService;
    @Autowired
    PatientService patientService;



    @GetMapping("/allRendezVous")
    public String findAll(Model model) {
        model.addAttribute("RendezVous", RendezVousService.finaAllRendezVous());
        return "RendezVous";
    }

    @GetMapping("/addRendezVous")
    public String lunchAddRendezVousPage(Model model) {
        model.addAttribute("RendezVous", new RendezVous());
        model.addAttribute("patients", patientService.findallPatient());
        return "add-RendezVous";
    }



    @PostMapping("/addR")
    public String createRendezVous(RendezVous RendezVous, @RequestParam("dateR") String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date dateReservation = dateFormat.parse(date);
        RendezVous.setDateReservation(dateReservation);
        System.out.println(dateReservation);
        RendezVousService.addRendezVous(RendezVous);
        return "redirect:/allRendezVous";
    }


    @GetMapping("/RendezVous/edit/{id}")
    public String EditRendezVousPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("RendezVous", RendezVousService.findRendezVousById(id));
        model.addAttribute("patients", patientService.findallPatient());
        return "edit-RendezVous";

    }

    @PostMapping("/updateRendezVous")
    public String upadteRendezVous( RendezVous  RendezVous, @RequestParam("dateR") String date)throws ParseException {


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date dateReservation = dateFormat.parse(date);
        RendezVous.setDateReservation(dateReservation);
        System.out.println(dateReservation);
        RendezVousService.updateRendezVous( RendezVous);
        return "redirect:/allRendezVous";
    }


    @GetMapping("/RendezVous/delete/{id}")
    public String deleteRendezVous(@PathVariable("id") int id) {
        RendezVousService.deleteRendezVousById(id);
        return "redirect:/allRendezVous";


    }


    @PostMapping("/searchRendezVous")
    public String searchRendezVous(Model model, @RequestParam("name") String patient) {
        List<RendezVous> RendezVous = RendezVousService.searchPatientByRendezVous(patient);
        model.addAttribute("RendezVous", RendezVous);

        return "RendezVous";
    }








}
