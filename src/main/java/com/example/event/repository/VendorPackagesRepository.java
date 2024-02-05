package com.example.event.repository;


import com.example.event.model.VendorPackages;
import com.example.event.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorPackagesRepository extends JpaRepository<VendorPackages,Integer> {

    VendorPackages save(Optional<VendorPackages> existingVisitor);
}