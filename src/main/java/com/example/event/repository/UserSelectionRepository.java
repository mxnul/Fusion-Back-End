package com.example.event.repository;

import com.example.event.model.UserSelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSelectionRepository extends JpaRepository<UserSelection, Integer> {

    UserSelection findByVisitorId(int id);
}
