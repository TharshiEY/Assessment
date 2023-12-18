package com.niq.assessment.common.mapper;

import com.niq.assessment.domain.ProductMetadata;
import com.niq.assessment.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public static ProductMetadata maptodto(ProductDto productDto){
        if (productDto == null) {
            throw new IllegalArgumentException("productDto cannot be null");
        }
        ProductMetadata productMetadata = new ProductMetadata();
        productMetadata.setProductId(productDto.getProductId());
        productMetadata.setCategory(productDto.getCategory());
        productMetadata.setBrand(productDto.getBrand());
        return productMetadata;
    }

    private ProductDto mapToDto(ProductMetadata productEntity) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(productEntity.getProductId());
        productDto.setCategory(productEntity.getCategory());
        productDto.setBrand(productEntity.getBrand());
        return productDto;
    }
}
