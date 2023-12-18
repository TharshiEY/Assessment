package com.niq.assessment.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ShopperPersonalizedProductListDto {
    private String shopperId;
    private ArrayList<ShelfDto> shelf;
}
