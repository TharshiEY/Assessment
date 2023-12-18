package com.niq.dataTeam.controller;

import com.niq.dataTeam.Dto.ShopperPersonalizedProductListDto;
import com.niq.dataTeam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shopperPersonalizedProduct")
public class ShopperPersonalizedProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ShopperPersonalizedProductListDto shopperPersonalizedProductListDto) {
        String res = productService.saveShopperPersonalizedProduct(shopperPersonalizedProductListDto);
        return ResponseEntity.ok(res);
    }
}
