package com.example.event.model;

import javax.persistence.*;

@Entity
@Table(name = "UserSelection")
public class UserSelection {

    @Id
    private int visitorId;
    private int vendorId;
    private int propertyOwnerId;
    private int eventOrganizerId;
    private String eventCategory;

    public UserSelection() {
    }

    public UserSelection(int visitorId, int vendorId, int propertyOwnerId, int eventOrganizerId, String eventCategory) {

        this.visitorId = visitorId;
        this.vendorId = vendorId;
        this.propertyOwnerId = propertyOwnerId;
        this.eventOrganizerId = eventOrganizerId;
        this.eventCategory = eventCategory;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getPropertyOwnerId() {
        return propertyOwnerId;
    }

    public void setPropertyOwnerId(int propertyOwnerId) {
        this.propertyOwnerId = propertyOwnerId;
    }

    public int getEventOrganizerId() {
        return eventOrganizerId;
    }

    public void setEventOrganizerId(int eventOrganizerId) {
        this.eventOrganizerId = eventOrganizerId;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }
}
