package com.inditex.albus.inditex.application.dto.response;

import lombok.Data;

import java.util.Date;

/**
 * Objeto response de price
 * @author sbalbus
 */
@Data
public class PriceResponse {
    private int productId;
    private int brandId;
    private double priceToApply;
    private String startDate;
    private String endDate;
    private double finalPrice;
}
