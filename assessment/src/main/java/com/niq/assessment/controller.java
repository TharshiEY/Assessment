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
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping("/api/product")
public class controller {

    @Autowired
    ProductMetadataRepository productMetadataRepository;
    @Autowired
    ShopperPersonalizedProductListRepository shopperPersonalizedProductListRepository;

    @Autowired
    ShelfRepository shelfRepository;

    @Autowired
    private ProductService productService;



    @GetMapping("/get-products")
    public List<ProductMetadata> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit) {
        log.info("Assessment Service: ProductServiceImpl.getProductsByShopper() Invoked.");
        List<ProductMetadata> products = productService.getProductsByShopper(shopperId, category, brand, limit);
        return products;
    }

    @GetMapping("/get-shopper")
    public List<ShopperPersonalizedProductList> getShopperByProduct(
            @RequestParam String productId,
            @RequestParam(defaultValue = "10") int limit) {
        log.info("Assessment Service: ProductServiceImpl.getShopperByProduct() Invoked.");
        List<ShopperPersonalizedProductList> shoppers = productService.getShopperByProduct(productId, limit);
        return shoppers;
    }
}
