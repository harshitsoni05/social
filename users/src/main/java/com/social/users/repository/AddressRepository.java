package com.social.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.social.users.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,String>{
    @Query(value = "Select * from address where userId = :userId and userType = :userType", nativeQuery = true)
    List<Address> findByUser(@Param("userId") String userId, @Param("userType") String userType);
} 
