package com.example.event.service;

import com.example.event.model.Vendor;
import com.example.event.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    public Vendor loginVendor(String userName, String password){


        return vendorRepository.findByUserNameAndPassword(userName, password);
    }

    public Vendor addVendor(Vendor vendor){
        vendorRepository.save(vendor);
        return vendor;
    }

    public Vendor updateVendor(Optional<Vendor> existingVendor){
        return vendorRepository.save(existingVendor);
    }

    public void deleteVendorById(int id){
        vendorRepository.deleteById(id);
    }

    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendor(int id){
        return vendorRepository.findById(id);
    }

}
