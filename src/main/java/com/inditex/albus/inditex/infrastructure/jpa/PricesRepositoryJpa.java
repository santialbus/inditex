package com.inditex.albus.inditex.infrastructure.jpa;

import com.inditex.albus.inditex.application.ports.out.PricesRepository;
import com.inditex.albus.inditex.infrastructure.model.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * repositorio del price
 */
public interface PricesRepositoryJpa extends JpaRepository<PricesEntity, Long>, PricesRepository {


    @Query("SELECT p FROM PricesEntity p " +
            "WHERE :applicationDate BETWEEN p.startDate AND p.endDate " +
            "AND p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "AND p.priority = (SELECT MAX(sub.priority) FROM PricesEntity sub " +
            "WHERE :applicationDate BETWEEN sub.startDate AND sub.endDate " +
            "AND sub.productId = :productId " +
            "AND sub.brandId = :brandId)")
    Optional<PricesEntity> findByStartDateAndProductIdAndBrandId(@Param("applicationDate") String applicationDate,
                                                                 @Param("productId") Integer productId,
                                                                 @Param("brandId") Integer brandId);

    Boolean existsByProductId(Integer productId);

    Boolean existsByBrandId(Integer brandId);
}
