package com.example.event.controller;

import com.example.event.model.VendorPackages;
import com.example.event.service.VendorPackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/vendorPackages")
public class VendorPackagesController {

    @Autowired
    VendorPackagesService vendorPackagesService;


    @PostMapping("/addVendorPackages")
    public ResponseEntity<VendorPackages> addVendorPackages(@RequestBody VendorPackages vendorPackages) {

        try {

            VendorPackages newVendorPackages = vendorPackagesService.addVendorPackages(vendorPackages);
            return new ResponseEntity<>(newVendorPackages, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateVendorPackages")
    public ResponseEntity<VendorPackages> updateVendorPackages(@PathVariable int id, @RequestBody VendorPackages vendorPackages) {

        try {
            Optional<VendorPackages> existingVendorPackages = vendorPackagesService.getVendorPackages(id);

            if (existingVendorPackages == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            VendorPackages updatedVendorPackages = vendorPackagesService.updateVendorPackages(existingVendorPackages);
            return new ResponseEntity<>(updatedVendorPackages, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteVendorPackages/{id}")
    public ResponseEntity<VendorPackages> deleteVendorPackagesById(@PathVariable int id) {

        try {

            vendorPackagesService.deleteVendorPackagesById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllVendorPackages")
    public ResponseEntity<Object> getAllUsers(){
        try{
            List<VendorPackages> vendorPackagesList = vendorPackagesService.getAllVendorPackages();
            if(!vendorPackagesList.isEmpty()){
                return new ResponseEntity<>(vendorPackagesList, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getVendorPackages/{id}")
    public ResponseEntity<Object> getVendorPackagesById(@PathVariable(value = "id")int id){
        try{
            Optional<VendorPackages> vendorPackages = vendorPackagesService.getVendorPackages(id);
            if(vendorPackages != null){
                return new ResponseEntity<>(vendorPackages, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
