package com.niq.assessment;

import com.niq.assessment.domain.ProductMetadata;
import com.niq.assessment.domain.ShelfItem;
import com.niq.assessment.domain.ShopperPersonalizedProductList;
import com.niq.assessment.dto.ProductDto;
import com.niq.assessment.dto.ShelfDto;
import com.niq.assessment.dto.ShopperPersonalizedProductListDto;
import com.niq.assessment.repository.ProductMetadataRepository;
import com.niq.assessment.repository.ShelfRepository;
import com.niq.assessment.repository.ShopperPersonalizedProductListRepository;
import com.niq.assessment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
public class controller {

    @Autowired
    ProductMetadataRepository productMetadataRepository;
    @Autowired
    ShopperPersonalizedProductListRepository shopperPersonalizedProductListRepository;

    @Autowired
    ShelfRepository shelfRepository;

//    @PostMapping("/save")
//    public ResponseEntity<ProductMetadata> save(@RequestBody ProductMetadata productMetadata) {
//        ProductMetadata products = productMetadataRepository.save(productMetadata);
//        return ResponseEntity.ok(products);
//    }

//    @PostMapping("/save1")
//    public String save(@RequestBody ShopperPersonalizedProductListDto shopperPersonalizedProductListDto) {
//        List<ShelfDto> shelfItemList = shopperPersonalizedProductListDto.getShelf();
//
//        ShopperPersonalizedProductList personalizedProductList = new ShopperPersonalizedProductList();
//        personalizedProductList.setShopperId(shopperPersonalizedProductListDto.getShopperId());
//
//        List<ShelfItem> shelf = shelfItemList.stream()
//                .map(shelfItem -> {
//                    ShelfItem shelfItem1 = new ShelfItem();
//                    shelfItem1.setRelevancyScore(shelfItem.getRelevancyScore());
//
//                    ProductMetadata productMetadata = new ProductMetadata();
//                    productMetadata.setProductId(shelfItem.getProductId());
//
//                    shelfItem1.setProductMetadata(productMetadata);
//                    shelfItem1.setShopperPersonalizedProductList(personalizedProductList);
//
//                    return shelfItem1;
//                })
//                .collect(Collectors.toList());
//
//        personalizedProductList.setShelf(shelf);
//
//        shopperPersonalizedProductListRepository.save(personalizedProductList);
//
//        return "Saved!!";
//    }


    @Autowired
    private ProductService productService;



    @GetMapping("/get-products")
    public List<ProductMetadata> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit) {
        List<ProductMetadata> products = productService.getProductsByShopper(shopperId, category, brand, limit);
        return products;
    }

    @GetMapping("/get-shopper")
    public List<ShopperPersonalizedProductList> getShopperByProduct(
            @RequestParam String productId,
            @RequestParam(defaultValue = "10") int limit) {
        List<ShopperPersonalizedProductList> shoppers = productService.getShopperByProduct(productId, limit);
        return shoppers;
    }
}
