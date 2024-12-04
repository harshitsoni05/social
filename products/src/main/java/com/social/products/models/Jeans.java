package com.social.products.models;

public class Jeans implements Category{
    String jeansId;

    @Override
    public String getCategoryId() {
        return this.jeansId;
    }
    
}
