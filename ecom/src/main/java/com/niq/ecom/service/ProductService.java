package com.niq.ecom.service;

import com.niq.ecom.dto.ProductDto;
import com.niq.ecom.dto.ShopperPersonalizedProductList;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProductsByShopper(String shopperId, String category, String brand, int limit);

    List<ShopperPersonalizedProductList> getShopperByProduct(String productId, int limit);
}
