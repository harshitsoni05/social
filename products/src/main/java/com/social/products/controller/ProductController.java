package com.social.products.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.products.models.Products;
import com.social.products.repositories.ProductsRepository;
import com.social.products.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct (@RequestBody Products product) {
        Products saved = productService.addProduct(product);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getProduct (@PathVariable String id) {
        return ResponseEntity.ok(this.productsRepository.findById(id));
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<?> getProductBySeller (@PathVariable String sellerId) {
        return ResponseEntity.ok(this.productsRepository.findBySellerId(sellerId));
    }

    @PatchMapping("/id/{id}")
    public ResponseEntity<?> editProduct (@PathVariable String id, @RequestBody Map<String, Object> updatedFields) {
        productService.editProduct(id, updatedFields);
        return ResponseEntity.ok("Updated the product entry successfully!");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteProduct (@PathVariable String id) {
        this.productsRepository.deleteById(id);
        return ResponseEntity.ok("Deleted the product entry successfully!");
    }

    @PatchMapping("/seller/{sellerId}")
    public ResponseEntity<?> editProductSeller (@PathVariable String sellerId, @RequestBody Map<String, Object> updatedFields) {
        productService.editProductSeller(sellerId, updatedFields);
        return ResponseEntity.ok("Updated the product entry successfully!");
    }
}
