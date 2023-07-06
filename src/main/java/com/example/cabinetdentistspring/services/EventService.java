package com.example.cabinetdentistspring.services;

import com.example.cabinetdentistspring.models.Event;
import com.example.cabinetdentistspring.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private  EventRepository eventRepository;

    public List<Event> findallEvent() {
        return (List<Event>) eventRepository.findAll();
    }




    public Event findEventById(Integer id) {
        Optional<Event> result = eventRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return new Event();
    }

    public Event addEvent(Event Event) {
        return eventRepository.save(Event);
    }



    public Event updateEvent(Event Event) {
        return eventRepository.save(Event);
    }

    public void deleteEventById(Integer id) {
        eventRepository.deleteById(id);
    }


}
