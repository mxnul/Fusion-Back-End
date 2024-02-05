package com.example.event.controller;

import com.example.event.model.PropertyOwner;
import com.example.event.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/propertyOwner")
public class PropertyOwnerController {

    @Autowired
    PropertyOwnerService propertyOwnerService;

    @PostMapping("/login")
    public ResponseEntity<Object> propertyOwnerLogin(@RequestBody PropertyOwner p){
        String userName = p.getUserName();
        String password = p.getPassword();
        PropertyOwner propertyOwner = propertyOwnerService.loginPropertyOwner(userName, password);

        if (propertyOwner == null) {
            return new ResponseEntity<>("Email or Password mismatch", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }

        if(propertyOwner.getAccountActive() == true){
            return new ResponseEntity<>(propertyOwner, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User Not Approved",HttpStatus.CREATED);
        }
    }

    @PostMapping("/addPropertyOwner")
    public ResponseEntity<PropertyOwner> addPropertyOwner(@RequestBody PropertyOwner propertyOwner) {

        try {

            PropertyOwner newPropertyOwner = propertyOwnerService.addPropertyOwner(propertyOwner);
            return new ResponseEntity<>(newPropertyOwner, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatePropertyOwner")
    public ResponseEntity<PropertyOwner> updatePropertyOwner(@PathVariable int id, @RequestBody PropertyOwner propertyOwner) {

        try {
            Optional<PropertyOwner> existingPropertyOwner = propertyOwnerService.getPropertyOwner(id);

            if (existingPropertyOwner == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            PropertyOwner updatedPropertyOwner = propertyOwnerService.updatePropertyOwner(existingPropertyOwner);
            return new ResponseEntity<>(updatedPropertyOwner, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletePropertyOwner/{id}")
    public ResponseEntity<PropertyOwner> deletePropertyOwnerById(@PathVariable int id) {

        try {

            propertyOwnerService.deletePropertyOwnerById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllPropertyOwners")
    public ResponseEntity<Object> getAllPropertyOwners() {
        try {
            List<PropertyOwner> propertyOwnerList = propertyOwnerService.getAllPropertyOwners();
            if (!propertyOwnerList.isEmpty()) {
                return new ResponseEntity<>(propertyOwnerList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPropertyOwner/{id}")
    public ResponseEntity<Object> getPropertyOwnerById(@PathVariable int id) {
        try {
            Optional<PropertyOwner> propertyOwner = propertyOwnerService.getPropertyOwner(id);
            if (propertyOwner != null) {
                return new ResponseEntity<>(propertyOwner, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
