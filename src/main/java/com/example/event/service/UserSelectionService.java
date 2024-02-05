package com.example.event.service;

import com.example.event.model.*;
import com.example.event.repository.UserSelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSelectionService {

    @Autowired
    private UserSelectionRepository userSelectionRepository;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private EventOrganizerService eventOrganizerService;

    @Autowired
    private PropertyOwnerService propertyOwnerService;

    public UserSelection addUserSelection(UserSelection userSelection){
        userSelectionRepository.save(userSelection);
        return userSelection;
    }

    public UserSelectionDTO getUserSelectionDetails(int visitorId){
        UserSelection foundUserSelection = userSelectionRepository.findByVisitorId(visitorId);

        Vendor vendor = null;
        if (foundUserSelection.getVendorId() != 0) {
            vendor = vendorService.getVendor(foundUserSelection.getVendorId()).orElse(null);
        }

        EventOrganizer eventOrganizer = null;
        if (foundUserSelection.getEventOrganizerId() != 0) {
            eventOrganizer = eventOrganizerService.getEventOrganizer(foundUserSelection.getEventOrganizerId()).orElse(null);
        }

//        Vendor vendor = vendorService.getVendor(foundUserSelection.getVendorId()).get();
//        EventOrganizer eventOrganizer = eventOrganizerService.getEventOrganizer(foundUserSelection.getEventOrganizerId()).get();
        PropertyOwner propertyOwner = propertyOwnerService.getPropertyOwner(foundUserSelection.getPropertyOwnerId()).get();
        String eventCategory = foundUserSelection.getEventCategory();

        UserSelectionDTO userSelectionDTO = new UserSelectionDTO(visitorId,vendor,propertyOwner,eventOrganizer,eventCategory);

        return userSelectionDTO;
    }
}

