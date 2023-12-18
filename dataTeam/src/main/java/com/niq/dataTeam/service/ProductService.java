package com.niq.dataTeam.service;

import com.niq.dataTeam.Dto.ProductDto;
import com.niq.dataTeam.Dto.ShopperPersonalizedProductListDto;

public interface ProductService {

    public String saveProduct(ProductDto productDto);

    public String saveShopperPersonalizedProduct(ShopperPersonalizedProductListDto shopperPersonalizedProductListDto);
}
