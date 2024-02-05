package com.example.event.service;

import com.example.event.model.VenuePackages;
import com.example.event.repository.VenuePackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenuePackagesService {

    @Autowired
    VenuePackagesRepository venuePackagesRepository;

    public VenuePackages addVenuePackages(VenuePackages venuePackages) {
        venuePackagesRepository.save(venuePackages);
        return venuePackages;
    }

    public VenuePackages updateVenuePackages(Optional<VenuePackages> existingVenuePackages) {
        return venuePackagesRepository.save(existingVenuePackages);
    }

    public void deleteVenuePackagesById(int id) {
        venuePackagesRepository.deleteById(id);
    }

    public List<VenuePackages> getAllVenuePackages() {
        return venuePackagesRepository.findAll();
    }

    public Optional<VenuePackages> getVenuePackages(int id) {
        return venuePackagesRepository.findById(id);
    }

}
