package com.niq.dataTeam.Dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ShopperPersonalizedProductListDto {
    private String shopperId;
    private ArrayList<ShelfDto> shelf;
}
