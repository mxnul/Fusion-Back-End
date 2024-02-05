package com.example.event.service;

import com.example.event.model.EventOrganizerPackage;
import com.example.event.repository.EventOrganizerPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventOrganizerPackageService {

    @Autowired
    EventOrganizerPackageRepository eventOrganizerPackagesRepository;

    public EventOrganizerPackage addEventOrganizerPackage(EventOrganizerPackage eventOrganizerPackage) {
        eventOrganizerPackagesRepository.save(eventOrganizerPackage);
        return eventOrganizerPackage;
    }

    public EventOrganizerPackage updateEventOrganizerPackage(Optional<EventOrganizerPackage> existingEventOrganizerPackage) {
        return eventOrganizerPackagesRepository.save(existingEventOrganizerPackage);
    }

    public void deleteEventOrganizerPackageById(int id) {
        eventOrganizerPackagesRepository.deleteById(id);
    }

    public List<EventOrganizerPackage> getAllEventOrganizerPackages() {
        return eventOrganizerPackagesRepository.findAll();
    }

    public Optional<EventOrganizerPackage> getEventOrganizerPackage(int id) {
        return eventOrganizerPackagesRepository.findById(id);
    }

}
