package com.inditex.albus.inditex.infrastructure.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase dto de excepcion
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceNotFoundExceptionResponse {
    private String message;
    private String details;

}
