package com.social.users.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.users.model.Address;
import com.social.users.model.Buyer;
import com.social.users.service.BuyerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getBuyer(@RequestParam String id) {
        Buyer buyer = this.buyerService.getBuyer(id);
        return ResponseEntity.ok(buyer);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postBuyer(@RequestBody Buyer  buyer) {
        return ResponseEntity.ok(this.buyerService.addBuyer(buyer));
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editBuyer(@RequestParam String id,@RequestBody Buyer  buyer) {
        return ResponseEntity.ok(this.buyerService.editBuyer(id,buyer));
    }
    
    @GetMapping("/get/{id}/address")
    public ResponseEntity<?> getAddress(@RequestParam String id) {
        return ResponseEntity.ok(this.buyerService.getAddress(id));
    }

    @PostMapping("/post/{id}/address")
    public ResponseEntity<?> postAddress(@RequestParam String id, @RequestBody Address address) {
        return ResponseEntity.ok(this.buyerService.addAddress(id, address));
    }

    @PatchMapping("/edit/{id}/address/{addressId}")
    public ResponseEntity<?> editAddress(@RequestParam String id, @RequestParam String addressId, @RequestBody Address address) {
        return ResponseEntity.ok(this.buyerService.editAddress(addressId,address));
    }

    @DeleteMapping("/delete/{id}/address/{addressId}")
    public ResponseEntity<?> deleteAddress(@RequestParam String id, @RequestParam String addressId) {
        return ResponseEntity.ok(this.buyerService.deleteAddress(id, addressId));
    }
    
}
