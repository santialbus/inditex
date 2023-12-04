package com.inditex.albus.inditex.application.service.impl;

import com.inditex.albus.inditex.application.service.PricesServiceImpl;
import com.inditex.albus.inditex.domain.Prices;
import com.inditex.albus.inditex.domain.request.PriceRequest;
import com.inditex.albus.inditex.domain.response.PriceResponse;
import com.inditex.albus.inditex.infrastructure.adapter.PricesDataAdapter;
import com.inditex.albus.inditex.infrastructure.model.PricesEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    private PricesDataAdapter adapter;
    static PricesEntity price1, price2, price3, price4;
    @BeforeEach
    public void setup() {
        price1 = new PricesEntity(1L, 1, "2020-06-14 00:00:00", "2020-12-31 23:59:59", 1.0, 35455, 0, 35.50, "EUR");
        price2 = new PricesEntity(2L, 1, "2020-06-14 15:00:00", "2020-06-14 18:30:00", 2.0, 35455, 1, 25.45, "EUR");
        price3 = new PricesEntity(3L, 1, "2020-06-15 00:00:00", "2020-06-15 11:00:00", 3.0, 35455, 1, 30.50, "EUR");
        price4 = new PricesEntity(4L, 1, "2020-06-15 16:00:00", "2020-12-31 23:59:59", 4.0, 35455, 1, 38.95, "EUR");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void test_1() {
        String dateTimeString = "2020-06-14T10:00:00";
        PriceRequest priceRequest = new PriceRequest(dateTimeString, 35455, 1);
        PricesEntity simulatedPrice = price1;
        when(adapter.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        Prices response = pricesService.retrieveData(dateTimeString, priceRequest.getProductId(), priceRequest.getBrandId());
        assertEquals(35.50, response.getPrice());
    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void test_2() {
        PriceRequest priceRequest = new PriceRequest("2020-06-14T16:00:00", 35455, 1);
        PricesEntity simulatedPrice = price2;
        when(adapter.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        Prices response = pricesService.retrieveData(priceRequest.getApplicationDate(), priceRequest.getProductId(), priceRequest.getBrandId());
        assertEquals(25.45, response.getPrice());
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void test_3() {
        PriceRequest priceRequest = new PriceRequest("2020-06-14T21:00:00", 35455, 1);
        PricesEntity simulatedPrice = price4;
        when(adapter.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        Prices response = pricesService.retrieveData(priceRequest.getApplicationDate(), priceRequest.getProductId(), priceRequest.getBrandId());
        assertEquals(38.95, response.getPrice());
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    public void test_4() {
        PriceRequest priceRequest = new PriceRequest("2020-06-15T10:00:00", 35455, 1);
        PricesEntity simulatedPrice = price3;
        when(adapter.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        Prices response = pricesService.retrieveData(priceRequest.getApplicationDate(), priceRequest.getProductId(), priceRequest.getBrandId());
        assertEquals(30.50, response.getPrice());
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    public void test_5() {
        PriceRequest priceRequest = new PriceRequest("2020-06-16T21:00:00", 35455, 1);
        PricesEntity simulatedPrice = price4;
        when(adapter.findByStartDateAndProductIdAndBrandId(any(), anyInt(), anyInt()))
                .thenReturn(Optional.of(simulatedPrice));
        Prices response = pricesService.retrieveData(priceRequest.getApplicationDate(), priceRequest.getProductId(), priceRequest.getBrandId());
        assertEquals(38.95, response.getPrice());
    }

}