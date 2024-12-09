package com.social.products.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.social.products.models.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products,String>{
    Products findById(String id);
    List<Products> findBySellerId(String sellerId);
    Void deleteById(String id);
}
