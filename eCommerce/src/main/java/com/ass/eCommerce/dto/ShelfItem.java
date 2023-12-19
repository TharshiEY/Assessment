package com.ass.eCommerce.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class ShelfItem {
    private Long id;

    @JsonBackReference
    private ShopperPersonalizedProductList shopperPersonalizedProductList;

    private ProductDto productMetadata;

    private double relevancyScore;
}
