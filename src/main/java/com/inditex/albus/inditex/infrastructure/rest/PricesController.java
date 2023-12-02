package com.inditex.albus.inditex.infrastructure.rest;

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
    @GetMapping()
    public ResponseEntity<PriceResponse> getPrice(@RequestParam String applicationDate,
                                                         @RequestParam Integer productId,
                                                         @RequestParam Integer brandId) {
        return new ResponseEntity<>(pricesService.retrieveData(applicationDate, productId, brandId), HttpStatus.OK);
    }

    /**
     * Añade los precios
     * @return String, HttpStatus
     */
    @PostMapping()
    public ResponseEntity<String> addMockPrices() {
        return new ResponseEntity<>(pricesService.addMockPrices(), HttpStatus.OK);
    }
}
