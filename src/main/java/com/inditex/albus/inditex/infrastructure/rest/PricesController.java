package com.inditex.albus.inditex.infrastructure.rest;

import com.inditex.albus.inditex.domain.dto.response.PriceResponse;
import com.inditex.albus.inditex.application.ports.in.PricesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prices")
@Tag(name = "Prices")
public class PricesController {

    @Autowired
    private PricesService pricesService;

    /**
     * Metodo de consulta de precios
     * @param applicationDate
     * @param productId
     * @param brandId
     * @return ResponseEntity<PriceResponse>
     */
    @Operation(
            description = "Obtener precio",
            summary = "Endpoint para obtener el precio",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                    description = "Price not found",
                    responseCode = "500"
            )
            }
    )
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
    @Operation(
            description = "Añadir precios",
            summary = "Endpoint para añadir precios",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @PostMapping()
    public ResponseEntity<String> addMockPrices() {
        return new ResponseEntity<>(pricesService.addMockPrices(), HttpStatus.OK);
    }
}
