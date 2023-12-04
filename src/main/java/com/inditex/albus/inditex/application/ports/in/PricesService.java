package com.inditex.albus.inditex.application.ports.in;

import com.inditex.albus.inditex.domain.Prices;

/**
 * interfaz del service de price
 */
public interface PricesService {

    Prices retrieveData(String applicationDate, Integer productId, Integer brandId);

    String addMockPrices();

}
