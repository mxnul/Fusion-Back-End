package com.example.event.controller;


import com.example.event.model.VenuePackages;
import com.example.event.service.VenuePackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/venuePackages")
public class VenuePackagesController {

    @Autowired
    VenuePackagesService venuePackagesService;

    @PostMapping("/addVenuePackages")
    public ResponseEntity<VenuePackages> addVenuePackages(@RequestBody VenuePackages venuePackages) {

        try {

            VenuePackages newVenuePackages = venuePackagesService.addVenuePackages(venuePackages);
            return new ResponseEntity<>(newVenuePackages, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateVenuePackages")
    public ResponseEntity<VenuePackages> updateVenuePackages(@PathVariable int id, @RequestBody VenuePackages venuePackages) {

        try {
            Optional<VenuePackages> existingVenuePackages = venuePackagesService.getVenuePackages(id);

            if (existingVenuePackages == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            VenuePackages updatedVenuePackages = venuePackagesService.updateVenuePackages(existingVenuePackages);
            return new ResponseEntity<>(updatedVenuePackages, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteVenuePackages/{id}")
    public ResponseEntity<VenuePackages> deleteVenuePackagesById(@PathVariable int id) {

        try {

            venuePackagesService.deleteVenuePackagesById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllVenuePackages")
    public ResponseEntity<Object> getAllUsers(){

        try{
            List<VenuePackages> venuePackagesList = venuePackagesService.getAllVenuePackages();
            if(!venuePackagesList.isEmpty()){
                return new ResponseEntity<>(venuePackagesList, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getVenuePackages/{id}")
    public ResponseEntity<Object> getVenuePackagesById(@PathVariable int id){
        try{
            Optional<VenuePackages> venuePackages = venuePackagesService.getVenuePackages(id);
            if(venuePackages != null){
                return new ResponseEntity<>(venuePackages, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
