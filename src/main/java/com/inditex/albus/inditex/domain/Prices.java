package com.inditex.albus.inditex.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prices {
    private Long id;
    private Integer brandId;
    private String startDate;
    private String endDate;
    private Double priceList;
    private Integer productId;
    private Integer priority;
    private Double price;
    private String curr;
}
