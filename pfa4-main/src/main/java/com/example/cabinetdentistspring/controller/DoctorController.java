
package com.example.cabinetdentistspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {
    @GetMapping("/doctor")
    public String getDoctor() {
        return "Doctor";
    }
}
