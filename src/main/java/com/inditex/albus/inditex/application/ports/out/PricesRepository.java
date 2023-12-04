package com.inditex.albus.inditex.application.ports.out;

import com.inditex.albus.inditex.infrastructure.model.PricesEntity;

import java.util.Optional;

/**
 *
 * Repositorio del precio.
 */
public interface PricesRepository {

    Optional<PricesEntity> findByStartDateAndProductIdAndBrandId(String applicationDate,
                                                                 Integer productId,
                                                                 Integer brandId);
    Boolean existsByProductId(Integer productId);

    Boolean existsByBrandId(Integer brandId);

}
