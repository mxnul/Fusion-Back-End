package com.example.event.controller;


import com.example.event.model.EventOrganizer;
import com.example.event.service.EventOrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/eventOrganizer")
public class EventOrganizerController {
    @Autowired
    EventOrganizerService eventOrganizerService;


    @PostMapping("/login")
    public ResponseEntity<Object> eventOrganizerLogin(@RequestBody String userName, @RequestBody String password){

        EventOrganizer eventOrganizer= eventOrganizerService.loginEventOrganizer(userName, password);

        if (eventOrganizer == null) {
            return new ResponseEntity<>("Email or Password mismatch", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    }

    @PostMapping("/addEventOrganizer")
    public ResponseEntity<EventOrganizer> addEventOrganizer(@RequestBody EventOrganizer eventOrganizer) {

        try {

            EventOrganizer newEventOrganizer = eventOrganizerService.addEventOrganizer(eventOrganizer);
            return new ResponseEntity<>(newEventOrganizer, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateEventOrganizer")
    public ResponseEntity<EventOrganizer> updateEventOrganizer(@PathVariable int id,@RequestBody EventOrganizer eventOrganizer) {

        try {
            Optional<EventOrganizer> existingEventOrganizer= eventOrganizerService.getEventOrganizer(id);

            if(existingEventOrganizer == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            EventOrganizer updatedEventOrganizer = eventOrganizerService.updateEventOrganizer(existingEventOrganizer);
            return new ResponseEntity<>(updatedEventOrganizer, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEventOrganizer/{id}")
    public ResponseEntity<EventOrganizer> deleteEventOrganizerById(@PathVariable int id) {

        try {

            eventOrganizerService.deleteEventOrganizerById(id);
            return new ResponseEntity<>( HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllEventOrganizer")
    public ResponseEntity<Object> getAllEventOrganizer(){
        try{
            List<EventOrganizer> eventOrganizerList = eventOrganizerService.getAllEventOrganizer();
            if(!eventOrganizerList.isEmpty()){
                return new ResponseEntity<>(eventOrganizerList,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getEventOrganizer/{id}")
    public ResponseEntity<Object> getEventOrganizerById(@PathVariable(value = "id")int id){
        try{
            Optional<EventOrganizer> eventOrganizer = eventOrganizerService.getEventOrganizer(id);
            if(eventOrganizer != null){
                return new ResponseEntity<>(eventOrganizer, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
