package com.inditex.albus.inditex.infrastructure.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Objeto entity del price
 */
@Entity
@Data
@Table(name="prices")
@AllArgsConstructor
@NoArgsConstructor
public class PricesEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "price_list")
    private Double priceList;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private Double price;

    @Column(name = "curr")
    private String curr;
}
