package com.example.event.service;

import com.example.event.model.PropertyOwner;
import com.example.event.repository.PropertyOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyOwnerService {

    @Autowired
    PropertyOwnerRepository propertyOwnerRepository;

    public PropertyOwner loginPropertyOwner(String userName, String password) {
        return propertyOwnerRepository.findByUserNameAndPassword(userName, password);
    }

    public PropertyOwner addPropertyOwner(PropertyOwner propertyOwner) {
        propertyOwnerRepository.save(propertyOwner);
        return propertyOwner;
    }

    public PropertyOwner updatePropertyOwner(Optional<PropertyOwner> existingPropertyOwner) {
        return propertyOwnerRepository.save(existingPropertyOwner);
    }

    public void deletePropertyOwnerById(int id) {
        propertyOwnerRepository.deleteById(id);
    }

    public List<PropertyOwner> getAllPropertyOwners() {
        return propertyOwnerRepository.findAll();
    }

    public Optional<PropertyOwner> getPropertyOwner(int id) {
        return propertyOwnerRepository.findById(id);
    }

}
