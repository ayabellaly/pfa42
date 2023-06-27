package com.example.cabinetdentistspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ApplicationController {
    @GetMapping("/")
    public String gohome() {
        return "index1";
    }







}
