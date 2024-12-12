package com.social.users.model;

import jakarta.persistence.Entity;

@Entity
public class Address extends EntityModel{
    private String id;
    private String userId;
    private String userType;
    private String lineOne;
    private String lineTwo;
    private int postalCode;
    private String city;
    private String state;
    private String country;
    private String mobile;

    public Address(String id, String userId, String userType, String lineOne, String lineTwo, int postalCode, String city, String state, String country,
            String mobile, String createdTimestamp) {
        this.id = id;
        this.userId = userId;
        this.userType = userType;
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setuserId(String userId) {
        this.userId = userId;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getLineOne() {
        return lineOne;
    }
    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }
    public String getLineTwo() {
        return lineTwo;
    }
    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    
}
