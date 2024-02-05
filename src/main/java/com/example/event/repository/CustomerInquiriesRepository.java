package com.example.event.repository;

import com.example.event.model.CustomerInquiries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface CustomerInquiriesRepository extends JpaRepository<CustomerInquiries,Integer> {
    CustomerInquiries save(Optional<CustomerInquiries> customerInquiries);
    List<CustomerInquiries> findByEventCategoryAndCategoryId(String eventCategory, Integer categoryId);
}
