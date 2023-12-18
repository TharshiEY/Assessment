package com.niq.assessment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shelf_item")
public class ShelfItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shelf_item_id")
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "shopper_id", referencedColumnName = "shopper_id")
    private ShopperPersonalizedProductList shopperPersonalizedProductList;


    @OneToOne
    @JoinColumn(name = "product_id", nullable = true)
    private ProductMetadata productMetadata;



    @Column(name = "relevancy_score")
    private double relevancyScore;
}
