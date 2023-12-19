package com.niq.ecom.service;

import com.niq.ecom.dto.ProductDto;
import com.niq.ecom.dto.ShopperPersonalizedProductList;
import com.niq.ecom.feignClient.ServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ServiceFeignClient serviceFeignClient;

    @Override
    public List<ProductDto> getProductsByShopper(String shopperId, String category, String brand, int limit) {
        List<ProductDto> productDtoList = serviceFeignClient.getProductsByShopper(shopperId,category,brand,limit);
        return serviceFeignClient.getProductsByShopper(shopperId,category,brand,limit);
    }

    @Override
    public List<ShopperPersonalizedProductList> getShopperByProduct(String productId, int limit) {
        return serviceFeignClient.getShopperByProduct(productId,limit);
    }
}
