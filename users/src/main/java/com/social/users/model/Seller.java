package com.social.users.model;

import jakarta.persistence.Entity;

@Entity
public class Seller extends User{
    private String businessType;
    private String addressId;
    Seller(String id, String name, String email, String mobile, String businessType, String addressId){
        super(id, name, email, mobile);
        this.businessType = businessType;
        this.addressId = addressId;
    }
}
