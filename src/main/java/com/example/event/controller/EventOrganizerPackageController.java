package com.example.event.controller;


import com.example.event.model.EventOrganizerPackage;
import com.example.event.service.EventOrganizerPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/eventOrganizerPackage")
public class EventOrganizerPackageController {

    @Autowired
    EventOrganizerPackageService eventOrganizerPackageService;

    @PostMapping("/addEventOrganizerPackage")
    public ResponseEntity<EventOrganizerPackage> addEventOrganizerPackage(@RequestBody EventOrganizerPackage eventOrganizerPackage) {

        try {

            EventOrganizerPackage newEventOrganizerPackage = eventOrganizerPackageService.addEventOrganizerPackage(eventOrganizerPackage);
            return new ResponseEntity<>(newEventOrganizerPackage, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateEventOrganizerPackage/{id}")
    public ResponseEntity<EventOrganizerPackage> updateEventOrganizerPackage(@PathVariable int id, @RequestBody EventOrganizerPackage eventOrganizerPackage) {

        try {
            Optional<EventOrganizerPackage> existingEventOrganizerPackage = eventOrganizerPackageService.getEventOrganizerPackage(id);

            if (existingEventOrganizerPackage == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            EventOrganizerPackage updatedEventOrganizerPackage = eventOrganizerPackageService.updateEventOrganizerPackage(existingEventOrganizerPackage);
            return new ResponseEntity<>(updatedEventOrganizerPackage, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEventOrganizerPackage/{id}")
    public ResponseEntity<EventOrganizerPackage> deleteEventOrganizerPackageById(@PathVariable int id) {

        try {

            eventOrganizerPackageService.deleteEventOrganizerPackageById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllEventOrganizerPackages")
    public ResponseEntity<Object> getAllEventOrganizerPackages(){
        try{
            List<EventOrganizerPackage> eventOrganizerPackageList = eventOrganizerPackageService.getAllEventOrganizerPackages();
            if(!eventOrganizerPackageList.isEmpty()){
                return new ResponseEntity<>(eventOrganizerPackageList, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getEventOrganizerPackage/{id}")
    public ResponseEntity<Object> getEventOrganizerPackageById(@PathVariable(value = "id")int id){
        try{
            Optional<EventOrganizerPackage> eventOrganizerPackage = eventOrganizerPackageService.getEventOrganizerPackage(id);
            if(eventOrganizerPackage != null){
                return new ResponseEntity<>(eventOrganizerPackage, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
