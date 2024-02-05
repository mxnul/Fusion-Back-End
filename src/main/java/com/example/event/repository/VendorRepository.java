package com.example.event.repository;


import com.example.event.model.Vendor;
import com.example.event.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Integer> {

    Vendor findByUserNameAndPassword(String userName, String password);

    Vendor save(Optional<Vendor> existingVisitor);
}