package com.niq.assessment.common.mapper;

import com.niq.assessment.domain.ProductMetadata;
import com.niq.assessment.domain.ShelfItem;
import com.niq.assessment.domain.ShopperPersonalizedProductList;
import com.niq.assessment.dto.ProductDto;
import com.niq.assessment.dto.ShelfDto;
import com.niq.assessment.dto.ShopperPersonalizedProductListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopperMapper {

    @Autowired
    ProductMapper productMapper;


    public static ShopperPersonalizedProductList mapToEntity(ShopperPersonalizedProductListDto dto) {
        ShopperPersonalizedProductList entity = new ShopperPersonalizedProductList();
        entity.setShopperId(dto.getShopperId());

        if (dto.getShelf() != null) {
            List<ShelfItem> shelfItems = dto.getShelf().stream()
                    .map(ShopperMapper::mapToShelfItem)
                    .collect(Collectors.toList());
            entity.setShelf(shelfItems);
        }

        return entity;
    }

    private static ShelfItem mapToShelfItem(ShelfDto shelfDto) {
        ShelfItem shelfItem = new ShelfItem();
        shelfItem.setRelevancyScore(shelfDto.getRelevancyScore());
        ProductMetadata productMetadata = mapToProductMetadata(shelfDto);
        shelfItem.setProductMetadata(productMetadata);

        return shelfItem;
    }

    private static ProductMetadata mapToProductMetadata(ShelfDto shelfDto) {

        ProductMetadata productMetadata = new ProductMetadata();
        productMetadata.setProductId(shelfDto.getProductId());
        return productMetadata;
    }

//    public static ShopperPersonalizedProductList maptodto(ShopperPersonalizedProductListDto listDto){
//        if (listDto == null) {
//            throw new IllegalArgumentException("ShopperPersonalizedProductListDto cannot be null");
//        }
//        ShopperPersonalizedProductList shopperPersonalizedProductList = new ShopperPersonalizedProductList();
//        shopperPersonalizedProductList.setShopperId(listDto.getShopperId());
//        shopperPersonalizedProductList.setShelf(listDto.getShelf());
//    }
}
