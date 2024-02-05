package com.example.event.repository;

import com.example.event.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface VisitorRepository extends JpaRepository<Visitor,Integer> {

    Visitor findByUserNameAndPassword(String userName, String password);

    Visitor save(Optional<Visitor> existingVisitor);
}

