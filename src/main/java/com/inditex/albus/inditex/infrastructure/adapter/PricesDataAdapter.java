package com.inditex.albus.inditex.infrastructure.adapter;

import com.inditex.albus.inditex.application.ports.out.PricesRepository;
import com.inditex.albus.inditex.infrastructure.jpa.PricesRepositoryJpa;
import com.inditex.albus.inditex.infrastructure.model.PricesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PricesDataAdapter implements PricesRepository {

    @Autowired
    private PricesRepositoryJpa pricesRepositoryJpaSpringData;


    @Override
    public Optional<PricesEntity> findByStartDateAndProductIdAndBrandId(String applicationDate, Integer productId, Integer brandId) {
        return pricesRepositoryJpaSpringData.findByStartDateAndProductIdAndBrandId(applicationDate, productId, brandId);
    }

    @Override
    public Boolean existsByProductId(Integer productId) {
        return pricesRepositoryJpaSpringData.existsByProductId(productId);
    }

    @Override
    public Boolean existsByBrandId(Integer brandId) {
        return pricesRepositoryJpaSpringData.existsByBrandId(brandId);
    }

    public void saveAll(List<PricesEntity> prices) {
        pricesRepositoryJpaSpringData.saveAll(prices);
    }
}
