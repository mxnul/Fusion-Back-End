package com.example.event.controller;


import com.example.event.model.Inquiry;
import com.example.event.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/inquiry")
public class InquiryController {

    @Autowired
    InquiryService inquiryService;

    @PostMapping("/addInquiry")
    public ResponseEntity<Inquiry> addInquiry(@RequestBody Inquiry inquiry) {

        try {

            Inquiry newInquiry = inquiryService.addInquiry(inquiry);
            return new ResponseEntity<>(newInquiry, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateInquiry")
    public ResponseEntity<Inquiry> updateInquiry(@PathVariable int id, @RequestBody Inquiry inquiry) {

        try {
            Optional<Inquiry> existingInquiry = inquiryService.getInquiry(id);

            if (existingInquiry == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Inquiry updatedInquiry = inquiryService.updateInquiry(existingInquiry);
            return new ResponseEntity<>(updatedInquiry, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteInquiry/{id}")
    public ResponseEntity<Inquiry> deleteInquiryById(@PathVariable int id) {

        try {

            inquiryService.deleteInquiryById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllInquiries")
    public ResponseEntity<Object> getAllUsers(){
        try{
            List<Inquiry> inquiryList = inquiryService.getAllInquiries();
            if(!inquiryList.isEmpty()){
                return new ResponseEntity<>(inquiryList, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getInquiry/{id}")
    public ResponseEntity<Object> getInquiryById(@PathVariable(value = "id")int id){
        try{
            Optional<Inquiry> inquiry = inquiryService.getInquiry(id);
            if(inquiry != null){
                return new ResponseEntity<>(inquiry, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
