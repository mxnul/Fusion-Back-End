package com.example.event.service;

import com.example.event.model.Admin;
import com.example.event.model.Vendor;
import com.example.event.repository.AdminRepository;
import com.example.event.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    VendorRepository vendorRepository;

    public Admin loginAdmin(String userName, String password){
        return adminRepository.findByUserNameAndPassword(userName, password);
    }

}
