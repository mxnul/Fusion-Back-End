package com.example.event.service;

import com.example.event.model.Inquiry;
import com.example.event.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InquiryService {

    @Autowired
    InquiryRepository inquiryRepository;

    public Inquiry addInquiry(Inquiry inquiry) {
        inquiryRepository.save(inquiry);
        return inquiry;
    }

    public Inquiry updateInquiry(Optional<Inquiry> existingInquiry) {
        return inquiryRepository.save(existingInquiry);
    }

    public void deleteInquiryById(int id) {
        inquiryRepository.deleteById(id);
    }

    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    public Optional<Inquiry> getInquiry(int id) {
        return inquiryRepository.findById(id);
    }

}
