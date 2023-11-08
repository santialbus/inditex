package com.inditex.albus.inditex.application.service;

import com.inditex.albus.inditex.application.dto.request.PriceRequest;
import com.inditex.albus.inditex.application.dto.response.PriceResponse;
import org.springframework.stereotype.Service;

/**
 * interfaz del service de price
 */
public interface PricesService {

    PriceResponse consultaDatos(PriceRequest priceRequest);

    void anyadirPrices();

}
