package com.example.event.controller;


import com.example.event.model.Admin;
import com.example.event.model.EventOrganizer;
import com.example.event.model.PropertyOwner;
import com.example.event.model.Vendor;
import com.example.event.repository.EventOrganizerRepository;
import com.example.event.repository.PropertyOwnerRepository;
import com.example.event.repository.VendorRepository;
import com.example.event.service.AdminService;
import com.example.event.service.EventOrganizerService;
import com.example.event.service.PropertyOwnerService;
import com.example.event.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    VendorService vendorService;

    @Autowired
    EventOrganizerService eventOrganizerService;

    @Autowired
    PropertyOwnerService propertyOwnerService;

    @PostMapping("/login")
    public ResponseEntity<Object> adminLogin(@RequestBody Admin v){

        String userName = v.getUserName();
        String password = v.getPassword();
        Admin admin = adminService.loginAdmin(userName, password);

        if (admin == null) {
            return new ResponseEntity<>("Email or Password mismatch", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    }

    @PatchMapping("/vendor/activate/{id}")
    public Vendor activateVendor(@PathVariable int id) {
        Vendor vendor = vendorService.getVendor(id).orElse(null);

        if (vendor != null) {
            vendor.setAccountActive(true);
            vendorService.addVendor(vendor);
        }

        return vendor;
    }

    @PatchMapping("/venues/activate/{id}")
    public PropertyOwner activateVenue(@PathVariable int id) {
        PropertyOwner propertyOwner = propertyOwnerService.getPropertyOwner(id).orElse(null);

        if (propertyOwner != null) {
            propertyOwner.setAccountActive(true);
            propertyOwnerService.addPropertyOwner(propertyOwner);
        }

        return propertyOwner;
    }

    @PatchMapping("/eventOrganizer/activate/{id}")
    public EventOrganizer activateEventOrganizer(@PathVariable int id) {
        EventOrganizer eventOrganizer = eventOrganizerService.getEventOrganizer(id).orElse(null);

        if (eventOrganizer != null) {
            eventOrganizer.setAccountActive(true);
            eventOrganizerService.addEventOrganizer(eventOrganizer);
        }

        return eventOrganizer;
    }
}
