package com.example.event.repository;


import com.example.event.model.EventOrganizerPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventOrganizerPackageRepository extends JpaRepository<EventOrganizerPackage,Integer> {

    EventOrganizerPackage save(Optional<EventOrganizerPackage> existingVisitor);
}
