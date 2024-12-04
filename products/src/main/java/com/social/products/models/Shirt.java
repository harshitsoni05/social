package com.social.products.models;

public class Shirt implements Category{
    String shirtId;
    @Override
    public String getCategoryId() {
        return this.shirtId;
    }
    
}
