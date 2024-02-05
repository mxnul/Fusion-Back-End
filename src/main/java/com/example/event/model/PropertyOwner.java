package com.example.event.model;


import javax.persistence.*;

@Entity
@Table(name = "PropertyOwner")

public class PropertyOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ownerName;
    private String venueName;
    private String phone;
    private String description;
    private String location;
    private String email;
    private String userName;
    private String password;
    private String imageUrl;
    private Boolean accountActive;

    public PropertyOwner() {
    }

    public PropertyOwner(int id, String ownerName, String venueName, String phone, String description, String location, String email, String userName, String password, String imageUrl, Boolean accountActive) {
        this.id = id;
        this.ownerName = ownerName;
        this.venueName = venueName;
        this.phone = phone;
        this.description = description;
        this.location = location;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.imageUrl = imageUrl;
        this.accountActive = accountActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getAccountActive() {
        return accountActive;
    }

    public void setAccountActive(Boolean accountActive) {
        this.accountActive = accountActive;
    }
}
