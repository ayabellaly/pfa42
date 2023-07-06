package com.example.cabinetdentistspring.controller;
import com.example.cabinetdentistspring.models.Event;
import com.example.cabinetdentistspring.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EventController {


        @Autowired
       EventService eventService;



        @GetMapping("/allEvent")
        public String findAll(Model model) {
            model.addAttribute("Event", eventService.findallEvent());
            return "Event";
        }

        @GetMapping("/addE")
        public String lunchAddEventPage(Model model) {
            model.addAttribute("Event", new Event());
            return "add-Event";
        }

        @PostMapping("/addEvent")
        public String createEvent(Event Event, @RequestParam("dates") String date, @RequestParam("datef") String date2) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date startTime = dateFormat.parse(date);
            Date endTime = dateFormat.parse(date2);
            Event.setStartTime(startTime);
            Event.setEndTime(endTime);
            System.out.println(startTime);
            eventService.addEvent(Event);
            return "redirect:/allEvent";
        }

        @GetMapping("/Event/edit/{id}")
        public String lunchEditPage(Model model, @PathVariable("id") int id) {
            model.addAttribute("Event",eventService.findEventById(id));
            return "edit-Event";

        }

        @PostMapping("/updateEvent")
        public String updateEvent(Event Event, @RequestParam("dates") String date, @RequestParam("datef") String date2) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date startTime = dateFormat.parse(date);
            Date endTime = dateFormat.parse(date2);
            Event.setStartTime(startTime);
            Event.setEndTime(endTime);

            eventService.updateEvent(Event);
            return "redirect:/allEvent";
        }

        @GetMapping("/Event/delete/{id}")
        public String deleteEvent(@PathVariable("id") int id) {
            eventService.deleteEventById(id);
            return "redirect:/allEvent";
        }
    }
