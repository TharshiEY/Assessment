package com.niq.dataTeam.controller;

import com.niq.dataTeam.Dto.ProductDto;
import com.niq.dataTeam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ProductDto productMetadata) {
        String products = productService.saveProduct(productMetadata);
        return ResponseEntity.ok(products);
    }
}
