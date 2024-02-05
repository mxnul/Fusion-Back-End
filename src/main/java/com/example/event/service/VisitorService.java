package com.example.event.service;

import com.example.event.model.UserSelection;
import com.example.event.model.Visitor;
import com.example.event.repository.UserSelectionRepository;
import com.example.event.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {


    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Autowired
    UserSelectionRepository userSelectionRepository;

    public Visitor loginVisitor(String userName, String password){
        return visitorRepository.findByUserNameAndPassword(userName, password);
    }

    public Visitor addVisitor(Visitor visitor){ //method implementation
        visitorRepository.save(visitor);
        return visitor;
    }

    public Visitor updateVisitor(Optional<Visitor> existingVisitor){ //method implementation
        return visitorRepository.save(existingVisitor);
    }

    public void  deleteVisitorById(int id){ //method implementation
        visitorRepository.deleteById(id);

    }

    public List<Visitor> getAllVisitiors(){
        return visitorRepository.findAll();
    }

    public Optional<Visitor> getVisitior(int id){
        return visitorRepository.findById(id);
    }

    public UserSelection addUserSelection(UserSelection userSelection){
        return userSelectionRepository.save(userSelection);
    }
}
