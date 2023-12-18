package com.niq.assessment.repository;

import com.niq.assessment.domain.ProductMetadata;
import com.niq.assessment.domain.ShopperPersonalizedProductList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMetadataRepository extends JpaRepository<ProductMetadata,String> {
//    List<ProductMetadata> findByCategoryLikeIgnoreCaseAndBrandLikeIgnoreCaseAllIgnoreCase(@Nullable String category, @Nullable String brand, Pageable pageable);
//    List<ProductMetadata> findByShopperAndFilters(String shopperId, String category, String brand, int limit);


    List<ProductMetadata> findByProductIdInAndCategoryAndBrand(List<String> productIds, String category, String brand, PageRequest of);

    List<ProductMetadata> findByProductIdInAndCategory(List<String> productIds, String category, PageRequest of);

    List<ProductMetadata> findByProductIdInAndBrand(List<String> productIds, String brand, PageRequest of);

    List<ProductMetadata> findByProductIdIn(List<String> productIds, PageRequest of);
}
