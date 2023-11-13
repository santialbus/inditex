package com.inditex.albus.inditex.application.rest;

import com.inditex.albus.inditex.domain.dto.response.PriceResponse;
import com.inditex.albus.inditex.application.ports.in.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prices")
public class PricesController {

    @Autowired
    private PricesService pricesService;

    /**
     * Metodo de consulta de precios
     * @param applicationDate
     * @param productId
     * @param brandId
     * @return
     */
    @GetMapping("/consulta")
    public ResponseEntity<PriceResponse> consultarPrecio(@RequestParam String applicationDate,
                                                         @RequestParam Integer productId,
                                                         @RequestParam Integer brandId) {
        return new ResponseEntity<>(pricesService.consultaDatos(applicationDate, productId, brandId), HttpStatus.OK);
    }

    /**
     * Anyadir los prices dado que desde el sql creado peta
     * @return String, HttpStatus
     */
    @PostMapping("/anyadir")
    public ResponseEntity<String> anyadirPrices() {
        return new ResponseEntity<>(pricesService.anyadirPrices(), HttpStatus.OK);
    }
}
