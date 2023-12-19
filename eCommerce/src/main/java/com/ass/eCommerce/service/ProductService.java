package com.ass.eCommerce.service;

import com.ass.eCommerce.dto.ProductDto;
import com.ass.eCommerce.dto.ShopperPersonalizedProductList;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProductsByShopper(String shopperId, String category, String brand, int limit);

    List<ShopperPersonalizedProductList> getShopperByProduct(String productId, int limit);
}
