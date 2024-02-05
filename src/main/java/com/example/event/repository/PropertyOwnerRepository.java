package com.example.event.repository;


import com.example.event.model.PropertyOwner;
import com.example.event.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner,Integer> {

    PropertyOwner findByUserNameAndPassword(String userName, String password);

    PropertyOwner save(Optional<PropertyOwner> existingVisitor);
}
