package com.social.users.model;

public class Buyer extends User{
    private String buyerSeller;
    private String addressId;
    Buyer(String id, String name, String email, String mobile, String buyerSeller, String addressId){
        super(id, name, email, mobile);
        this.buyerSeller = buyerSeller;
        this.addressId = addressId;
    }
}
