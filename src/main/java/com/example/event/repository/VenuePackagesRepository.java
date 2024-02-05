package com.example.event.repository;


import com.example.event.model.VendorPackages;
import com.example.event.model.VenuePackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenuePackagesRepository extends JpaRepository<VenuePackages,Integer> {

    VenuePackages save(Optional<VenuePackages> existingVisitor);
}
