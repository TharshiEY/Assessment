package com.niq.ecom.dto;

import lombok.Data;
import java.util.List;

@Data
public class ShopperPersonalizedProductList {

    private String shopperId;

    private List<ShelfItem> shelf;
}
