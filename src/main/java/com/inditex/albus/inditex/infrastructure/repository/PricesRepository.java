package com.inditex.albus.inditex.infrastructure.repository;

import com.inditex.albus.inditex.application.dto.response.PriceResponse;
import com.inditex.albus.inditex.domain.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.print.attribute.IntegerSyntax;
import java.util.Date;
import java.util.Optional;

/**
 * repositorio del price
 */
public interface PricesRepository extends JpaRepository<Prices, Long> {


    @Query("SELECT p FROM Prices p " +
            "WHERE :applicationDate BETWEEN p.startDate AND p.endDate " +
            "AND p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "AND p.priority = (SELECT MAX(sub.priority) FROM Prices sub " +
            "WHERE :applicationDate BETWEEN sub.startDate AND sub.endDate " +
            "AND sub.productId = :productId " +
            "AND sub.brandId = :brandId)")
    Optional<Prices> findByStartDateAndProductIdAndBrandId(@Param("applicationDate") String applicationDate,
                                                           @Param("productId") Integer productId,
                                                           @Param("brandId") Integer brandId);
}
