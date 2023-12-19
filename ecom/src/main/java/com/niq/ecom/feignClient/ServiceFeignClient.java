package com.niq.ecom.feignClient;

import com.niq.ecom.dto.ProductDto;
import com.niq.ecom.dto.ShopperPersonalizedProductList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "http://localhost:9900") // URL of Service B
public interface ServiceFeignClient {

    @GetMapping("/api/product/get-products")
    public List<ProductDto> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit);


    @GetMapping("/api/product/get-shopper")
    public List<ShopperPersonalizedProductList> getShopperByProduct(
            @RequestParam String productId,
            @RequestParam(defaultValue = "10") int limit);
}
