package com.niq.assessment.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.niq.assessment.common.mapper.ProductMapper;
import com.niq.assessment.common.mapper.ShopperMapper;
import com.niq.assessment.domain.ProductMetadata;
import com.niq.assessment.domain.ShelfItem;
import com.niq.assessment.domain.ShopperPersonalizedProductList;
import com.niq.assessment.dto.ProductDto;
import com.niq.assessment.dto.ShelfDto;
import com.niq.assessment.dto.ShopperPersonalizedProductListDto;
import com.niq.assessment.repository.ProductMetadataRepository;
import com.niq.assessment.repository.ShelfRepository;
import com.niq.assessment.repository.ShopperPersonalizedProductListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductMetadataRepository productMetadataRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ShopperMapper shopperMapper;

    @Autowired
    ShopperPersonalizedProductListRepository shopperPersonalizedProductListRepository;

    @Autowired
    ShelfRepository shelfRepository;

    private static final String QUEUE_NAME = "product-queue";
    private static final String QUEUE_NAME2 = "shopper-queue";

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String message) {
        System.out.println("Received message from RabbitMQ: " + message);
        try {
            ProductDto productDto = objectMapper.readValue(message, ProductDto.class);
            log.info("productMetadata: {}", productDto);
            ProductMetadata productMetadata = productMapper.maptodto(productDto);
            ProductMetadata savedProduct = productMetadataRepository.save(productMetadata);
            log.info("Saved Product: {}", savedProduct);
        } catch (Exception e) {
            log.error("Error processing message", e);
        }
    }


    @RabbitListener(queues = QUEUE_NAME2)
    public void listenShopper(String message) {
        log.info("Received message from RabbitMQ: " + message);
        try {
            ShopperPersonalizedProductListDto dto = objectMapper.readValue(message, ShopperPersonalizedProductListDto.class);
            log.info("ShopperPersonalizedProductList: {}", dto);
//            ShopperPersonalizedProductList list = shopperMapper.mapToEntity(dto);

            List<ShelfDto> shelfItemList = dto.getShelf();

            ShopperPersonalizedProductList personalizedProductList = new ShopperPersonalizedProductList();
            personalizedProductList.setShopperId(dto.getShopperId());

            List<ShelfItem> shelf = shelfItemList.stream()
                    .map(shelfItem -> {
                        ShelfItem shelfItem1 = new ShelfItem();
                        shelfItem1.setRelevancyScore(shelfItem.getRelevancyScore());

                        ProductMetadata productMetadata = new ProductMetadata();
                        productMetadata.setProductId(shelfItem.getProductId());

                        shelfItem1.setProductMetadata(productMetadata);
                        shelfItem1.setShopperPersonalizedProductList(personalizedProductList);

                        return shelfItem1;
                    })
                    .collect(Collectors.toList());

            personalizedProductList.setShelf(shelf);

            shopperPersonalizedProductListRepository.save(personalizedProductList);

        }catch (Exception e){
            log.error("Error processing message", e);
        }
    }



//    private ProductDto mapToDto(ProductMetadata productEntity) {
//        ProductDto productDto = new ProductDto();
//        productDto.setProductId(productEntity.getProductId());
//        productDto.setCategory(productEntity.getCategory());
//        productDto.setBrand(productEntity.getBrand());
//        return productDto;
//    }


    @Override
    public List<ProductMetadata> getProductsByShopper(String shopperId, String category, String brand, int limit) {
        log.info("Assessment Service: ProductServiceImpl.getProductsByShopper() Invoked.");
        if (shopperId == null || shopperId.isEmpty()) {
            return null;
        }

        ShopperPersonalizedProductList personalizedProductList = shopperPersonalizedProductListRepository.findById(shopperId).orElse(null);

        if (personalizedProductList == null || personalizedProductList.getShelf() == null) {
            return null;
        }

        List<String> productIds = getProductIdsFromShelf(personalizedProductList.getShelf());

        if (category != null && brand != null) {
            return productMetadataRepository.findByProductIdInAndCategoryAndBrand(productIds, category, brand, PageRequest.of(0, limit));
        } else if (category != null) {
            return productMetadataRepository.findByProductIdInAndCategory(productIds, category, PageRequest.of(0, limit));
        } else if (brand != null) {
            return productMetadataRepository.findByProductIdInAndBrand(productIds, brand, PageRequest.of(0, limit));
        } else {
            return productMetadataRepository.findByProductIdIn(productIds, PageRequest.of(0, limit));
        }
    }


    @Override
    public List<ShopperPersonalizedProductList> getShopperByProduct(String productId, int limit) {
        log.info("Assessment Service: ProductServiceImpl.getShopperByProduct() Invoked.");
        if (productId == null || productId.isEmpty()) {
            return null;
        }
        return shopperPersonalizedProductListRepository.findByShelf_ProductMetadata_ProductIdLikeIgnoreCase(productId, PageRequest.of(0,limit));
    }

    private List<String> getProductIdsFromShelf(List<ShelfItem> shelf) {
        log.info("Assessment Service: ProductServiceImpl.getProductIdsFromShelf() Invoked.");
        return shelf.stream()
                .map(shelfItem -> shelfItem.getProductMetadata().getProductId())
                .toList();
    }
}
