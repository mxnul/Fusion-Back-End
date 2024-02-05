package com.example.event.service;

import com.example.event.model.VendorPackages;
import com.example.event.repository.VendorPackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorPackagesService {

    @Autowired
    VendorPackagesRepository vendorPackagesRepository;

    public VendorPackages addVendorPackages(VendorPackages vendorPackages) {
        vendorPackagesRepository.save(vendorPackages);
        return vendorPackages;
    }

    public VendorPackages updateVendorPackages(Optional<VendorPackages> existingVendorPackages) {
        return vendorPackagesRepository.save(existingVendorPackages);
    }

    public void deleteVendorPackagesById(int id) {
        vendorPackagesRepository.deleteById(id);
    }

    public List<VendorPackages> getAllVendorPackages() {
        return vendorPackagesRepository.findAll();
    }

    public Optional<VendorPackages> getVendorPackages(int id) {
        return vendorPackagesRepository.findById(id);
    }

}
