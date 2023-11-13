package com.inditex.albus.inditex.application.mapper;

import com.inditex.albus.inditex.domain.dto.response.PriceResponse;
import com.inditex.albus.inditex.infrastructure.model.Prices;

/**
 * Mapper del price
 */
public class PriceMapper {

    /**
     * Mapeado de la entidad prices al response
     * @param prices
     * @return priceResponse
     */
    public static PriceResponse fromPricesToResponse(Prices prices) {
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setProductId(prices.getProductId());
        priceResponse.setBrandId(prices.getBrandId());
        priceResponse.setPriceToApply(prices.getPriceList());
        priceResponse.setStartDate(prices.getStartDate());
        priceResponse.setEndDate(prices.getEndDate());
        priceResponse.setFinalPrice(prices.getPrice());
        return priceResponse;
    }

}
