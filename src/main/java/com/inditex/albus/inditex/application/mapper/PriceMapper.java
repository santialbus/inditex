package com.inditex.albus.inditex.application.mapper;

import com.inditex.albus.inditex.domain.Prices;
import com.inditex.albus.inditex.domain.response.PriceResponse;
import com.inditex.albus.inditex.infrastructure.model.PricesEntity;

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

    /**
     * Pasar de price entity a price domain
     * @param pricesEntity
     * @return price
     */
    public static Prices fromPricesEntityToPrices(PricesEntity pricesEntity) {
        Prices prices = new Prices();
        prices.setBrandId(pricesEntity.getBrandId());
        prices.setPriceList(pricesEntity.getPriceList());
        prices.setPrice(pricesEntity.getPrice());
        prices.setId(pricesEntity.getId());
        prices.setCurr(pricesEntity.getCurr());
        prices.setStartDate(pricesEntity.getStartDate());
        prices.setEndDate(pricesEntity.getEndDate());
        prices.setPriority(pricesEntity.getPriority());
        prices.setProductId(pricesEntity.getProductId());
        return prices;
    }

}
