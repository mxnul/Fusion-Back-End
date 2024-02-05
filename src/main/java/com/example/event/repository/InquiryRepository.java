package com.example.event.repository;


import com.example.event.model.Inquiry;
import com.example.event.model.PropertyOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry,Integer> {

    Inquiry save(Optional<Inquiry> existingVisitor);
}
