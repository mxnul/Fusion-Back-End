package com.example.event.model;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.awt.*;

public class UserSelectionDTO {
    private int visitorId;
    private Vendor vendor;
    private PropertyOwner propertyOwner;
    private EventOrganizer eventOrganizer;

    private String eventCategory;

    public UserSelectionDTO(int visitorId, Vendor vendor, PropertyOwner propertyOwner, EventOrganizer eventOrganizer, String eventCategory) {
        this.visitorId = visitorId;
        this.vendor = vendor;
        this.propertyOwner = propertyOwner;
        this.eventOrganizer = eventOrganizer;
        this.eventCategory = eventCategory;
    }

    public UserSelectionDTO() {
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public PropertyOwner getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(PropertyOwner propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public EventOrganizer getEventOrganizer() {
        return eventOrganizer;
    }

    public void setEventOrganizer(EventOrganizer eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }
}

