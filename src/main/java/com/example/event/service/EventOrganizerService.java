package com.example.event.service;

import com.example.event.model.EventOrganizer;
import com.example.event.repository.EventOrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventOrganizerService {

    @Autowired
    EventOrganizerRepository eventOrganizerRepository;

    public EventOrganizer loginEventOrganizer(String userName, String password){
        return eventOrganizerRepository.findByUserNameAndPassword(userName, password);
    }

    public EventOrganizer addEventOrganizer(EventOrganizer eventOrganizer){ //method implementation
        eventOrganizerRepository.save(eventOrganizer);
        return eventOrganizer;
    }

    public EventOrganizer updateEventOrganizer(Optional<EventOrganizer> existingEventOrganizer){ //method implementation
        return eventOrganizerRepository.save(existingEventOrganizer);
    }

    public void  deleteEventOrganizerById(int id){ //method implementation
        eventOrganizerRepository.deleteById(id);

    }

    public List<EventOrganizer> getAllEventOrganizer(){
        return eventOrganizerRepository.findAll();
    }

    public Optional<EventOrganizer> getEventOrganizer(int id){
        return eventOrganizerRepository.findById(id);
    }


}
