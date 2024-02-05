package com.example.event.model;


import javax.persistence.*;

@Entity
@Table(name = "EventOrganizerPackages")
public class EventOrganizerPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String packageName;
    private String packageType;
    private String packageDetails;
    private String price;
    private int packageOffer;
    private String imageUrl;

    public EventOrganizerPackage() {
    }

    public EventOrganizerPackage(int id, String packageName, String packageType, String packageDetails, String price, int packageOffer, String imageUrl) {
        this.id = id;
        this.packageName = packageName;
        this.packageType = packageType;
        this.packageDetails = packageDetails;
        this.price = price;
        this.packageOffer = packageOffer;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getPackageDetails() {
        return packageDetails;
    }

    public void setPackageDetails(String packageDetails) {
        this.packageDetails = packageDetails;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPackageOffer() {
        return packageOffer;
    }

    public void setPackageOffer(int packageOffer) {
        this.packageOffer = packageOffer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
