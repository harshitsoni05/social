package com.social.products.services;

import java.util.Map;


import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.products.models.Products;
import com.social.products.models.Seller;
import com.social.products.repositories.ProductsRepository;

@Service
public class ProductService {

    private final ObjectMapper objectMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    private final WebClient webClient;

    @Autowired
    private ProductsRepository productsRepository;

    @Value("${seller.service.url}")
    private String sellerServiceUrl;

    public ProductService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.baseUrl(sellerServiceUrl).build();
        this.objectMapper = objectMapper;
    }

    public Products addProduct (Products product){
        Seller seller = getSellerById(product.getSellerId());

        if (seller!=null){
            product.setSeller(seller);
            return saveProduct(product);
        } else {
            throw new RuntimeException("Seller doesn't exist!");
        }
    }

    public void editProduct (String id, Map<String, Object> updatedFields){
        Query query = new Query(Criteria.where("id").is(id));

        Update update = new Update();
        try {
            for (Map.Entry<String, Object> entry : updatedFields.entrySet()){
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                if (fieldValue!=null)
                    update.set("seller."+fieldName, fieldValue);
            }
            mongoTemplate.updateFirst(query, update, Products.class);
        } catch (Exception exception) {
            throw new RuntimeException("Couldn't update the product entry!");
        }

    }

    public void editProductSeller (String stringId, Map<String, Object> updatedFields){
        Query query = new Query(Criteria.where("sellerId").is(stringId));

        Update update = new Update();
        try {
            for (Map.Entry<String, Object> entry : updatedFields.entrySet()){
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                if (fieldValue!=null)
                    update.set(fieldName, fieldValue);
            }
            mongoTemplate.updateMulti(query, update, Products.class);
        } catch (Exception exception) {
            throw new RuntimeException("Couldn't update the product entry!");
        }

    }

    private Seller getSellerById(String sellerId){
        try{
            return webClient.get()
            .uri("/seller/{id}", sellerId)
            .retrieve()
            .bodyToMono(Seller.class)
            .block();
        } catch(Exception exception){
            return null;
        }
    }

    private Products saveProduct(Products product){
        Products saved = this.productsRepository.save(product);
        return saved;
    }


    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
    
}
