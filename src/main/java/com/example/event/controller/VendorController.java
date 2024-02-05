package com.example.event.controller;

import com.example.event.model.Vendor;
import com.example.event.model.Visitor;
import com.example.event.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/vendor")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @PostMapping("/login")
    public ResponseEntity<Object> vendorLogin(@RequestBody Vendor v){
        String userName = v.getUserName();
        String password = v.getPassword();
        Vendor vendor = vendorService.loginVendor(userName, password);

        if (vendor == null) {
            return new ResponseEntity<>("Email or Password mismatch", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }

        if(vendor.getAccountActive() == true){
            return new ResponseEntity<>(vendor, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User Not Approved",HttpStatus.CREATED);
        }


    }

    @PostMapping("/addVendor")
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {

        try {
            System.out.println(vendor);
            Vendor newVendor = vendorService.addVendor(vendor);

            return new ResponseEntity<>(newVendor, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateVendor")
    public ResponseEntity<Vendor> updateVendor(@PathVariable int id, @RequestBody Vendor vendor) {

        try {
            Optional<Vendor> existingVendor = vendorService.getVendor(id);

            if(existingVendor == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Vendor updatedVendor = vendorService.updateVendor(existingVendor);
            return new ResponseEntity<>(updatedVendor, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteVendor/{id}")
    public ResponseEntity<Vendor> deleteVendorById(@PathVariable int id) {

        try {

            vendorService.deleteVendorById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllVendors")
    public ResponseEntity<Object> getAllVendors(){
        try{
            List<Vendor> vendorList = vendorService.getAllVendors();
            if(!vendorList.isEmpty()){
                return new ResponseEntity<>(vendorList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getVendor/{id}")
    public ResponseEntity<Object> getVendorById(@PathVariable int id){
//        try{
//            Optional<Vendor> vendor = vendorService.getVendor(id);
//            if(vendor.isPresent()){
//                return new ResponseEntity<>(vendor, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        try{
            Optional<Vendor> vendor = vendorService.getVendor(id);
            if(vendor != null){
                return new ResponseEntity<>(vendor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
