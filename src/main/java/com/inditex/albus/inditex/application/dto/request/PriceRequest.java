package com.inditex.albus.inditex.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Objeto request de price
 * @author sbalbus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {

    private String applicationDate;
    private Integer productId;
    private Integer brandId;

}
