package com.social.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.users.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,String>{
    
    
} 
