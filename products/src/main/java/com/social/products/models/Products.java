package com.social.products.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Products {
    @Indexed(unique = true)
    private String id;
    private String name;
    private double price;
    private String sellerId;
    private Seller seller;
    private String image;
    private boolean isActive;
    private String modifiedTime;
    private String createdTime;
    private ProductSpecification specifications;
    private String categoryType;

    public Products(String id, String name, double price, String sellerId, Seller seller,String image,
            boolean isActive, String modifiedTime, String createdTime, ProductSpecification specifications, String categoryType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sellerId = sellerId;
        this.seller = seller;
        this.image = image;
        this.isActive = isActive;
        this.modifiedTime = modifiedTime;
        this.createdTime = createdTime;
        this.specifications = specifications;
        this.categoryType = categoryType;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getModifiedTime() {
        return modifiedTime;
    }
    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    public String getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
    public ProductSpecification getSpecifications() {
        return specifications;
    }
    public void setSpecifications(ProductSpecification specifications) {
        this.specifications = specifications;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategoryType() {
        return categoryType;
    }
    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
    public Seller getSeller() {
        return seller;
    }
    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    public String getSellerId() {
        return sellerId;
    }
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
}
