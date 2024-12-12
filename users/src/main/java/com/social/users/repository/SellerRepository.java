package com.social.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.users.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String>{
    
}