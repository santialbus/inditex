package com.inditex.albus.inditex.application.service;

import com.inditex.albus.inditex.application.dto.request.PriceRequest;
import com.inditex.albus.inditex.application.dto.response.PriceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * interfaz del service de price
 */
public interface PricesService {

    PriceResponse consultaDatos(String applicationDate, Integer productId, Integer brandId);

    String anyadirPrices();

}
