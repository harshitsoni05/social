package com.social.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.users.model.Address;
import com.social.users.model.Buyer;
import com.social.users.repository.BuyerRepository;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private AddressService addressService;

    public Buyer getBuyer(String sellerid){
        return this.buyerRepository.findById(sellerid).get();
    }

    public Buyer addBuyer(Buyer buyer){
        return this.buyerRepository.save(buyer);
    }

    public Buyer editBuyer(String id, Buyer buyer){
        return buyer;
    }

    public List<Address> getAddress (String addressId){
        return this.addressService.getAddress(addressId);
    }

    public Address addAddress (String userId, Address address){
        return this.addressService.addAddress(userId, address);
    }

    public Address editAddress (String addressId, Address address){
        return this.addressService.editAddress(addressId, address);
    }

    public String deleteAddress (String userId, String addressId){
        return this.addressService.deleteAddress(addressId);
    }
}
