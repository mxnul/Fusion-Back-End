package com.example.event.model;

import javax.persistence.*;

@Entity
@Table(name = "EventOrganizer")

public class EventOrganizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String description;
    private String email;
    private String userName;
    private String password;
    private String imageUrl;
    private Boolean accountActive;

    public EventOrganizer() {
    }

    public EventOrganizer(int id, String name, String phone, String description, String email, String userName, String password, String imageUrl, Boolean accountActive) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
