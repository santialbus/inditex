package com.inditex.albus.inditex.application.service;

import com.inditex.albus.inditex.domain.Prices;
import com.inditex.albus.inditex.application.mapper.PriceMapper;
import com.inditex.albus.inditex.application.ports.in.PricesService;
import com.inditex.albus.inditex.infrastructure.adapter.PricesDataAdapter;
import com.inditex.albus.inditex.infrastructure.model.PricesEntity;
import com.inditex.albus.inditex.infrastructure.exceptions.BrandIdNotFoundException;
import com.inditex.albus.inditex.infrastructure.exceptions.PriceNotFoundException;
import com.inditex.albus.inditex.infrastructure.exceptions.ProductIdNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final String MOCK_PRICES = "Acabas de añadir productos";

    @Autowired
    private PricesDataAdapter adapter;

    private static final Logger LOGGER = LoggerFactory.getLogger(PricesServiceImpl.class);


    /**
     * Metodo de consulta de precios
     * @param applicationDate
     * @param productId
     * @param brandId
     * @return priceResponse
     */
    @Override
    public Prices retrieveData(String applicationDate, Integer productId, Integer brandId) {
        LOGGER.info("Consultar datos del Product ID: {}, Brand ID: {}, Application Date: {}", productId, brandId, applicationDate);


        Optional<PricesEntity> pricesOptional = adapter.findByStartDateAndProductIdAndBrandId(applicationDate, productId,brandId);

        return pricesOptional.map(PriceMapper::fromPricesEntityToPrices)
                .orElseThrow(() -> {
                    if (!adapter.existsByProductId(productId)) {
                        LOGGER.error("No se encontró el Product ID: {}", productId);
                        throw new ProductIdNotFoundException("No se encontró ningún precio con el Product ID proporcionado");
                    } else if (!adapter.existsByBrandId(brandId)) {
                        LOGGER.error("No se encontró el Brand ID: {}", brandId);
                        throw new BrandIdNotFoundException("No se encontró ningún precio con el Brand ID proporcionado");
                    } else {
                        LOGGER.error("No se encontró el product ID: {}, Brand ID: {}, Application Date: {}", productId, brandId, applicationDate);
                        return new PriceNotFoundException("No se encontró ningún precio con los datos proporcionados");
                    }
                });
    }

    /**
     * Metodo de añadir prices
     * @return String
     */
    @Override
    public String addMockPrices() {
        List<PricesEntity> listPrices = new ArrayList<>();

        PricesEntity prices1 = new PricesEntity();
        prices1.setBrandId(1);
        prices1.setStartDate("2020-06-14 00:00:00");
        prices1.setEndDate("2020-12-31 23:59:59");
        prices1.setPriceList(1.0);
        prices1.setProductId(35455);
        prices1.setPriority(0);
        prices1.setPrice(35.50);
        prices1.setCurr("EUR");

        PricesEntity prices2 = new PricesEntity();
        prices2.setBrandId(1);
        prices2.setStartDate("2020-06-14 15:00:00");
        prices2.setEndDate("2020-06-14 18:30:00");
        prices2.setPriceList(2.0);
        prices2.setProductId(35455);
        prices2.setPriority(1);
        prices2.setPrice(25.45);
        prices2.setCurr("EUR");

        PricesEntity prices3 = new PricesEntity();
        prices3.setBrandId(1);
        prices3.setStartDate("2020-06-15 00:00:00");
        prices3.setEndDate("2020-06-15 11:00:00");
        prices3.setPriceList(3.0);
        prices3.setProductId(35455);
        prices3.setPriority(1);
        prices3.setPrice(30.50);
        prices3.setCurr("EUR");

        PricesEntity prices4 = new PricesEntity();
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

        adapter.saveAll(listPrices);

        return MOCK_PRICES;
    }
}
