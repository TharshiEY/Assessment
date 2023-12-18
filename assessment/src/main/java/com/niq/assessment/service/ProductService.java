package com.niq.assessment.service;

import com.niq.assessment.domain.ProductMetadata;
import com.niq.assessment.domain.ShopperPersonalizedProductList;
import com.niq.assessment.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductMetadata> getProductsByShopper(String shopperId, String category, String brand, int limit);

    List<ShopperPersonalizedProductList> getShopperByProduct(String productId, int limit);

//    List<ProductDto> getProductsByShopper(String shopperId, String category, String brand, int limit);

}
