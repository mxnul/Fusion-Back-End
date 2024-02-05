package com.example.event.repository;


import com.example.event.model.EventOrganizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventOrganizerRepository extends JpaRepository<EventOrganizer,Integer> {
    EventOrganizer findByUserNameAndPassword(String userName, String password);

    EventOrganizer save(Optional<EventOrganizer> existingVisitor);
}