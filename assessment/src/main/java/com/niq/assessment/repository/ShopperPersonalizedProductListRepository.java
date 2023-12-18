package com.niq.assessment.repository;

import com.niq.assessment.domain.ShopperPersonalizedProductList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopperPersonalizedProductListRepository extends JpaRepository<ShopperPersonalizedProductList, String> {
    List<ShopperPersonalizedProductList> findByShelf_ProductMetadata_ProductIdLikeIgnoreCase(@NonNull String productId, Pageable pageable);
//    List<ShopperPersonalizedProductList> findByShelfProductMetadataProductId(String productId, PageRequest of);
}
