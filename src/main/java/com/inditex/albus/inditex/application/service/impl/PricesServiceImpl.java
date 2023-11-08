package com.inditex.albus.inditex.application.service.impl;

import com.inditex.albus.inditex.application.dto.request.PriceRequest;
import com.inditex.albus.inditex.application.dto.response.PriceResponse;
import com.inditex.albus.inditex.application.mapper.PriceMapper;
import com.inditex.albus.inditex.application.service.PricesService;
import com.inditex.albus.inditex.domain.model.Prices;
import com.inditex.albus.inditex.infrastructure.exceptions.PriceNotFoundException;
import com.inditex.albus.inditex.infrastructure.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * service impl de la clase price
 */
@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepository repository;

    /**
     * Consulta de datos
     * @param priceRequest
     * @return PriceResponse
     */
    @Override
    public PriceResponse consultaDatos(PriceRequest priceRequest) {
        Optional<Prices> price = repository.findByStartDateAndProductIdAndBrandId(priceRequest.getApplicationDate(), priceRequest.getProductId(),  priceRequest.getBrandId());
        if (price.isEmpty()) {
            throw new PriceNotFoundException("No se encontro ningun precio con los datos proporcionados");
        }
        return price.map(PriceMapper::fromPricesToResponse).orElse(new PriceResponse());
    }

    /**
     * Metodo de añadir prices
     */
    @Override
    public void anyadirPrices() {
        List<Prices> listPrices = new ArrayList<>();

        Prices prices1 = new Prices();
        prices1.setBrandId(1);
        prices1.setStartDate("2020-06-14 00:00:00");
        prices1.setEndDate("2020-12-31 23:59:59");
        prices1.setPriceList(1.0);
        prices1.setProductId(35455);
        prices1.setPriority(0);
        prices1.setPrice(35.50);
        prices1.setCurr("EUR");

        Prices prices2 = new Prices();
        prices2.setBrandId(1);
        prices2.setStartDate("2020-06-14 15:00:00");
        prices2.setEndDate("2020-06-14 18:30:00");
        prices2.setPriceList(2.0);
        prices2.setProductId(35455);
        prices2.setPriority(1);
        prices2.setPrice(25.45);
        prices2.setCurr("EUR");

        Prices prices3 = new Prices();
        prices3.setBrandId(1);
        prices3.setStartDate("2020-06-15 00:00:00");
        prices3.setEndDate("2020-06-15 11:00:00");
        prices3.setPriceList(3.0);
        prices3.setProductId(35455);
        prices3.setPriority(1);
        prices3.setPrice(30.50);
        prices3.setCurr("EUR");

        Prices prices4 = new Prices();
        prices4.setBrandId(1);
        prices4.setStartDate("2020-06-15 16:00:00");
        prices4.setEndDate("2020-12-31 23:59:59");
        prices4.setPriceList(4.0);
        prices4.setProductId(35455);
        prices4.setPriority(1);
        prices4.setPrice(38.95);
        prices4.setCurr("EUR");

        listPrices.add(prices1);
        listPrices.add(prices2);
        listPrices.add(prices3);
        listPrices.add(prices4);

        repository.saveAll(listPrices);
    }
}
