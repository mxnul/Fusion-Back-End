package com.example.event.controller;

import com.example.event.model.CustomerInquiries;
import com.example.event.model.Visitor;
import com.example.event.service.CustomerInquiriesService;
import com.example.event.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/custom-inquiry")
public class CustomerInquiriesController {

    @Autowired
    CustomerInquiriesService customerInquiriesService;

    @Autowired
    VisitorService visitorService;

    @PostMapping("/addInquiry")
    public ResponseEntity<CustomerInquiries> addInquiry(@RequestBody CustomerInquiries inquiry) {

        try {

            CustomerInquiries newInquiry = customerInquiriesService.addInquiry(inquiry);
            return new ResponseEntity<>(newInquiry, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateInquiry")
    public ResponseEntity<CustomerInquiries> updateInquiry(@PathVariable int id, @RequestBody CustomerInquiries inquiry) {

        try {
            Optional<CustomerInquiries> existingInquiry = customerInquiriesService.getInquiry(id);

            if (existingInquiry == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            CustomerInquiries updatedInquiry = customerInquiriesService.updateInquiry(existingInquiry);
            return new ResponseEntity<>(updatedInquiry, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteInquiry/{id}")
    public ResponseEntity<CustomerInquiries> deleteInquiryById(@PathVariable int id) {

        try {

            customerInquiriesService.deleteInquiryById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllInquiries")
    public ResponseEntity<Object> getAllUsers(){
        try{
            List<CustomerInquiries> inquiryList = customerInquiriesService.getAllInquiries();
            if(!inquiryList.isEmpty()){
                return new ResponseEntity<>(inquiryList, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getInquiry/{type}/{id}")
    public ResponseEntity<Object> getInquiryById(@PathVariable String type,  @PathVariable Integer id){
        try{
            List<CustomerInquiries> inquiries =  customerInquiriesService.getInquiryByIdAndType(type, id);

            if (inquiries != null && !inquiries.isEmpty()) {
                List<Map<String, Object>> inquiryList = new ArrayList<>();

                for (CustomerInquiries inquiry : inquiries) {
                    Map<String, Object> inquiryMap = new HashMap<>();
                    inquiryMap.put("id", inquiry.getId());
                    inquiryMap.put("visitorId", inquiry.getVisitorId());
                    inquiryMap.put("description", inquiry.getDescription());
                    inquiryMap.put("category_id", inquiry.getCategory_id());
                    inquiryMap.put("event_category", inquiry.getEvent_category());

                    Optional<Visitor> visitor = visitorService.getVisitior(inquiry.getVisitorId());
                    if (visitor.isPresent()) {
                        Map<String, Object> visitorMap = new HashMap<>();
                        visitorMap.put("id", visitor.get().getId());
                        visitorMap.put("firstName", visitor.get().getFirstName());
                        visitorMap.put("lastName", visitor.get().getLastName());
                        visitorMap.put("password", visitor.get().getPassword());
                        visitorMap.put("email", visitor.get().getEmail());
                        visitorMap.put("phone", visitor.get().getPhone());
                        visitorMap.put("userName", visitor.get().getUserName());

                        inquiryMap.put("visitor", visitorMap);
                    }

                    inquiryList.add(inquiryMap);
                }

                Map<String, Object> result = new HashMap<>();
                result.put("inquiries", inquiryList);

                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
