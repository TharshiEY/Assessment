package com.ass.eCommerce.controller;


import com.ass.eCommerce.dto.ProductDto;
import com.ass.eCommerce.dto.ShopperPersonalizedProductList;
import com.ass.eCommerce.service.ProductService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/product")
public class controller {

    @Autowired
    ProductService productService;

    @GetMapping("/get-products")
    public ResponseEntity<List<ProductDto>> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit) {
        log.info("controller.getProductsByShopper() Invoked.");
        List<ProductDto> products = productService.getProductsByShopper(shopperId, category, brand, limit);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/get-shopper")
    public ResponseEntity<List<ShopperPersonalizedProductList>> getShopperByProduct(
            @RequestParam String productId,
            @RequestParam(defaultValue = "10") int limit) {
        log.info("controller.getShopperByProduct() Invoked.");
        List<ShopperPersonalizedProductList> shoppers = productService.getShopperByProduct(productId, limit);
        return ResponseEntity.ok(shoppers);
    }
}
