package com.social.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.users.model.Address;
import com.social.users.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;    

    public List<Address> getAddress(String addressId){
        return this.addressRepository.findByUser(addressId, "Buyer");
    }

    public Address addAddress(String userId, Address address){
        address.setuserId(userId);
        address.setUserType("Buyer");
        return this.addressRepository.save(address);
    }

    public Address editAddress(String addressId, Address address){
        address.setId(addressId);
        return this.addressRepository.save(address);
    }

    public String deleteAddress(String addressId){
        this.addressRepository.deleteById(addressId);
        return ("Address Deleted Succesfully!");
    }
}
