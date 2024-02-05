package com.example.event.service;

import com.example.event.model.CustomerInquiries;
import com.example.event.repository.CustomerInquiriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerInquiriesService {

    @Autowired
    CustomerInquiriesRepository customerInquiriesRepository;

    public CustomerInquiries addInquiry(CustomerInquiries inquiry) {
        customerInquiriesRepository.save(inquiry);
        return inquiry;
    }

    public CustomerInquiries updateInquiry(Optional<CustomerInquiries> existingInquiry) {
        return customerInquiriesRepository.save(existingInquiry);
    }

    public void deleteInquiryById(int id) {
        customerInquiriesRepository.deleteById(id);
    }

    public List<CustomerInquiries> getAllInquiries() {
        return customerInquiriesRepository.findAll();
    }

    public Optional<CustomerInquiries> getInquiry(int id) {
        return customerInquiriesRepository.findById(id);
    }

    public List<CustomerInquiries> getInquiryByIdAndType (String type, int id){
        return customerInquiriesRepository.findByEventCategoryAndCategoryId(type, id);
    }

}
