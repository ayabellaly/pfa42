package com.example.cabinetdentistspring.controller;

import com.example.cabinetdentistspring.DTO.UserDto;
import com.example.cabinetdentistspring.models.User;
import com.example.cabinetdentistspring.services.PrescriptionService;
import com.example.cabinetdentistspring.services.RendezVousService;
import com.example.cabinetdentistspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private RendezVousService rendezVousService;
    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    @RequestMapping("/Acceuil")
    public String AcceuilForm(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userRole = authentication.getAuthorities().iterator().next().getAuthority();
        LocalDateTime localDateTime = LocalDateTime.now();
        if (userRole.equals("Secretaire")) {
            return "Index-Secretaire";
        } else if (userRole.equals("Medecin")) {
            model.addAttribute("countRendezvous", rendezVousService.countRendezvous());
            model.addAttribute("countRendezvousToday", prescriptionService.count(localDateTime));
            return "Index-Medecin";
        }
        else
            return "redirect:/login";
    }



    @GetMapping("/registration")
    public String registrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(
            @ModelAttribute("user") UserDto userDto,
            BindingResult result,
            Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null)
            result.rejectValue("email", null,
                    "User already registered !!!");

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/registration";
        }

        userService.saveUser(userDto);
        return "redirect:/registration?success";
    }
}