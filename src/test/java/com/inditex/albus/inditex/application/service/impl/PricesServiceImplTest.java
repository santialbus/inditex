package com.inditex.albus.inditex.application.service.impl;

import com.inditex.albus.inditex.application.dto.request.PriceRequest;
import com.inditex.albus.inditex.application.dto.response.PriceResponse;
import com.inditex.albus.inditex.domain.model.Prices;
import com.inditex.albus.inditex.infrastructure.repository.PricesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricesServiceImplTest {

    @InjectMocks
    private PricesServiceImpl pricesService;

    @Mock
    private PricesRepository pricesRepository;
    static Prices price1, price2, price3, price4;
    @BeforeEach
    public void setup() {
        price1 = new Prices(1L, 1, "2020-06-14 00:00:00", "2020-12-31 23:59:59", 1.0, 35455, 0, 35.50, "EUR");
        price2 = new Prices(2L, 1, "2020-06-14 15:00:00", "2020-06-14 18:30:00", 2.0, 35455, 1, 25.45, "EUR");
        price3 = new Prices(3L, 1, "2020-06-15 00:00:00", "2020-06-15 11:00:00", 3.0, 35455, 1, 30.50, "EUR");
        price4 = new Prices(4L, 1, "2020-06-15 16:00:00", "2020-12-31 23:59:59", 4.0, 35455, 1, 38.95, "EUR");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPriceAt10AMOnDay14ForProduct35455AndBrand1() {
        String dateTimeString = "2020-06-14T10:00:00";
        PriceRequest priceRequest = new PriceRequest(dateTimeString, 35455, 1);
        Prices simulatedPrice = price1;
        when(pricesRepository.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        PriceResponse response = pricesService.consultaDatos(priceRequest);
        assertEquals(35.50, response.getFinalPrice());
        System.out.println("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
    }

    @Test
    public void testFindPriceAt16PMOnDay14ForProduct35455AndBrand1() {
        PriceRequest priceRequest = new PriceRequest("2020-06-14T16:00:00", 35455, 1);
        Prices simulatedPrice = price2;
        when(pricesRepository.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        PriceResponse response = pricesService.consultaDatos(priceRequest);

        assertEquals(25.45, response.getFinalPrice());
        System.out.println("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
    }

    @Test
    public void testFindPriceAt21PMOnDay14ForProduct35455AndBrand1() {
        PriceRequest priceRequest = new PriceRequest("2020-06-14T21:00:00", 35455, 1);
        Prices simulatedPrice = price4;
        when(pricesRepository.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        PriceResponse response = pricesService.consultaDatos(priceRequest);

        assertEquals(38.95, response.getFinalPrice());
        System.out.println("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)");
    }

    @Test
    public void testFindPriceAt10AMOnDay15ForProduct35455AndBrand1() {
        PriceRequest priceRequest = new PriceRequest("2020-06-15T10:00:00", 35455, 1);
        Prices simulatedPrice = price3;
        when(pricesRepository.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        PriceResponse response = pricesService.consultaDatos(priceRequest);

        assertEquals(30.50, response.getFinalPrice());
        System.out.println("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)");
    }

    @Test
    public void testFindPriceAt9PMOnDay16ForProduct35455AndBrand1() {
        PriceRequest priceRequest = new PriceRequest("2020-06-16T21:00:00", 35455, 1);
        Prices simulatedPrice = price4;
        when(pricesRepository.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        PriceResponse response = pricesService.consultaDatos(priceRequest);

        assertEquals(38.95, response.getFinalPrice());
        System.out.println("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)");
    }

}
