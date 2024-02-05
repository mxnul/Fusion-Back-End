package com.example.event.repository;

import com.example.event.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByUserNameAndPassword(String userName, String password);
}
