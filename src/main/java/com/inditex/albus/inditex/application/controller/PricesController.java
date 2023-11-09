package com.inditex.albus.inditex.application.controller;

import com.inditex.albus.inditex.application.dto.request.PriceRequest;
import com.inditex.albus.inditex.application.dto.response.PriceResponse;
import com.inditex.albus.inditex.application.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/prices")
public class PricesController {

    @Autowired
    private PricesService pricesService;

    /**
     * Metodo de consulta de precios
     * @param request
     * @return calculatedPrice
     */
    @PostMapping("/consulta")
    public ResponseEntity<PriceResponse> consultarPrecio(@RequestBody PriceRequest request) {
        PriceResponse calculatedPrice = pricesService.consultaDatos(request);
        return new ResponseEntity<>(calculatedPrice, HttpStatus.OK);
    }

    /**
     * Anyadir los prices dado que desde el sql creado peta
     * @return String, HttpStatus
     */
    @PostMapping("/anyadir")
    public ResponseEntity<String> anyadirPrices() {
        String productos = pricesService.anyadirPrices();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}
