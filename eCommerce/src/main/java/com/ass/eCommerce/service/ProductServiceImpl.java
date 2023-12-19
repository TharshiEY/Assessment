package com.ass.eCommerce.service;


import com.ass.eCommerce.dto.ProductDto;
import com.ass.eCommerce.dto.ShopperPersonalizedProductList;
import com.ass.eCommerce.feignClient.ServiceFeignClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ServiceFeignClient serviceFeignClient;

    @Override
    public List<ProductDto> getProductsByShopper(String shopperId, String category, String brand, int limit) {
        log.info("ProductServiceImpl.getProductsByShopper() Invoked.");
        List<ProductDto> productDtoList = serviceFeignClient.getProductsByShopper(shopperId,category,brand,limit);
        return serviceFeignClient.getProductsByShopper(shopperId,category,brand,limit);
    }

    @Override
    public List<ShopperPersonalizedProductList> getShopperByProduct(String productId, int limit) {
        log.info("ProductServiceImpl.getShopperByProduct() Invoked.");
        return serviceFeignClient.getShopperByProduct(productId,limit);
    }
}
