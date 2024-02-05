package com.example.event.controller;

import com.example.event.model.UserSelection;
import com.example.event.model.UserSelectionDTO;
import com.example.event.model.Visitor;
import com.example.event.service.UserSelectionService;
import com.example.event.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/visitor")
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @Autowired
    UserSelectionService userSelectionService;


    @PostMapping("/login")
    public ResponseEntity<Object> visitorLogin(@RequestBody Visitor v){
        String userName = v.getUserName();
        String password = v.getPassword();
        Visitor visitor = visitorService.loginVisitor(userName, password);

        if (visitor == null) {
            return new ResponseEntity<>("Email or Password mismatch",HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }

        return new ResponseEntity<>(visitor, HttpStatus.OK);
    }

    @PostMapping("/addVisitor")
    public ResponseEntity<Visitor> addVisitor(@RequestBody Visitor visitor) {

        try {

            Visitor newVisitor = visitorService.addVisitor(visitor);
            return new ResponseEntity<>(newVisitor, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @PutMapping("/updateVisitor/{id}")
//    public ResponseEntity<Visitor> updateVisitor(@PathVariable String id,@RequestBody Visitor visitor) {
//
//        try {
//            Optional<Visitor> existingVisitor = visitorService.getVisitior(id);
//
//            if(existingVisitor == null){
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//
//            Visitor updatedVisitor = visitorService.updateVisitor(visitor);
//            return new ResponseEntity<>(updatedVisitor, HttpStatus.OK);
//
//        } catch (Exception e) {
//
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @DeleteMapping("/deleteVisitor/{id}")
    public ResponseEntity<Visitor> deleteVisitorById(@PathVariable int id) {

        try {

            visitorService.deleteVisitorById(id);
            return new ResponseEntity<>( HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllVisitors")
    public ResponseEntity<Object> getAllUsers(){
        try{
            List<Visitor> visitorList = visitorService.getAllVisitiors();
            if(!visitorList.isEmpty()){
                return new ResponseEntity<>(visitorList,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getVisitor/{id}")
    public ResponseEntity<Object> getVisitorById(@PathVariable int id){
        try{
            Optional<Visitor> visitor = visitorService.getVisitior(id);
            if(visitor != null){
                return new ResponseEntity<>(visitor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addSelection")
    public ResponseEntity<UserSelection> addUserSelection(@RequestBody UserSelection userSelection){
        try {
            UserSelection newUserSelection = userSelectionService.addUserSelection(userSelection);
            return new ResponseEntity<>(newUserSelection, HttpStatus.CREATED);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //visitorId goes here
    @GetMapping("/getSelections/{id}")
    public ResponseEntity<Object> getUserSelections(@PathVariable int id){
        try{
            UserSelectionDTO userSelectionDTO = userSelectionService.getUserSelectionDetails(id);
            if(userSelectionDTO != null){
                return new ResponseEntity<>(userSelectionDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
