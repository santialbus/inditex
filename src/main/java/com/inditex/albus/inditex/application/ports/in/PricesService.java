package com.inditex.albus.inditex.application.ports.in;

import com.inditex.albus.inditex.domain.dto.response.PriceResponse;

/**
 * interfaz del service de price
 */
public interface PricesService {

    PriceResponse consultaDatos(String applicationDate, Integer productId, Integer brandId);

    String anyadirPrices();

}
