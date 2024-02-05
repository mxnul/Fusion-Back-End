package com.example.event.model;


import javax.persistence.*;

@Entity
@Table(name = "CustomInquiries")
public class CustomerInquiries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int visitorId;
    private String description;
    private String eventCategory;
    private int categoryId;

    public CustomerInquiries() {
    }

    public CustomerInquiries(int id, int visitor_id, String description, String event_category, int category_id) {
        this.id = id;
        this.visitorId = visitor_id;
        this.description = description;
        this.eventCategory = event_category;
        this.categoryId = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitor_id) {
        this.visitorId = visitor_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEvent_category() {
        return eventCategory;
    }

    public void setEvent_category(String event_category) {
        this.eventCategory = event_category;
    }

    public int getCategory_id() {
        return categoryId;
    }

    public void setCategory_id(int category_id) {
        this.categoryId = category_id;
    }
}
