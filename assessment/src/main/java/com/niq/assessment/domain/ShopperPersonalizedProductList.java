package com.niq.assessment.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "shopper_personalized_product_list")
public class ShopperPersonalizedProductList {

    @Id
    @Column(name = "shopper_id")
    private String shopperId;

//    @OneToMany(mappedBy = "shopperPersonalizedProductList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<ShelfItem> shelf;

    @OneToMany(mappedBy = "shopperPersonalizedProductList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ShelfItem> shelf;
}
