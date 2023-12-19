package com.ass.eCommerce.feignClient;


import com.ass.eCommerce.dto.ProductDto;
import com.ass.eCommerce.dto.ShopperPersonalizedProductList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "serviceB", url = "http://localhost:9900/api/product") // URL of Service B
public interface ServiceFeignClient {

    @GetMapping("/get-products")
    public List<ProductDto> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit);


    @GetMapping("/get-shopper")
    public List<ShopperPersonalizedProductList> getShopperByProduct(
            @RequestParam String productId,
            @RequestParam(defaultValue = "10") int limit);
}
