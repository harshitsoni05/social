package com.social.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.users.model.Seller;
import com.social.users.repository.SellerRepository;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private AddressService addressService;

    public void getSeller(String sellerid){
        
    }

    public void addSeller(Seller seller){
        this.sellerRepository.save(seller);
    }

    public void editSeller(Seller seller){
        
    }

    public void editAddress (String addressId){

    }

    public void deleteAddress (String addressId){

    }
}
