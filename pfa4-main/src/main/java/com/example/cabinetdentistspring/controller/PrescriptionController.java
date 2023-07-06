package com.example.cabinetdentistspring.controller;

import com.example.cabinetdentistspring.models.Prescription;

import com.example.cabinetdentistspring.models.RendezVous;
import com.example.cabinetdentistspring.services.PatientService;
import com.example.cabinetdentistspring.services.PrescriptionService;

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
public class PrescriptionController {



    @Autowired
    PrescriptionService pservice;
    @Autowired
    PatientService patientService;



    @GetMapping("/allPrescription")
    public String findAll(Model model) {
        model.addAttribute("Prescription", pservice.finaAllPrescription());
        return "Prescription";
    }

    @GetMapping("/addp")
    public String lunchAddPrescriptionPage(Model model) {
        model.addAttribute("Prescription", new Prescription());
        model.addAttribute("patients", patientService.findallPatient());
        return "add-prescription";
    }

    @PostMapping("/addPrescription")
    public String createPrescription(Prescription prescription, @RequestParam("date") String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date prescribedDate = dateFormat.parse(date);
            prescription.setPrescribedDate(prescribedDate);
            System.out.println(prescribedDate);


            pservice.addPrescription(prescription);



        return "redirect:/allPrescription";
    }

    @GetMapping("/Prescription/edit/{id}")
    public String lunchEditPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("Prescription", pservice.findPrescriptionById(id));
        return "Edit-prescription";

    }

    @PostMapping("/updatePrescription")
    public String upadtePrescription(Prescription Prescription) {
        pservice.updatePrescription(Prescription);


        return "redirect:/allPrescription";
    }

    @GetMapping("/Prescription/delete/{id}")
    public String deletePrescription(@PathVariable("id") int id) {
        pservice.deletePrescriptionById(id);
        return "redirect:/allPrescription";









    }



    @PostMapping("/searchPrescription")
    public String searchRendezVous(Model model, @RequestParam("name") String patient) {
        List<Prescription> RendezVous = pservice.searchPrescription(patient);
        model.addAttribute("Prescription", RendezVous);

        return "Prescription";
    }



























}
