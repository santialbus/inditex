package com.inditex.albus.inditex.infrastructure.exceptions.controller;

import com.inditex.albus.inditex.infrastructure.exceptions.BrandIdNotFoundException;
import com.inditex.albus.inditex.infrastructure.exceptions.PriceNotFoundException;
import com.inditex.albus.inditex.infrastructure.exceptions.ProductIdNotFoundException;
import com.inditex.albus.inditex.infrastructure.exceptions.dto.PriceNotFoundExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase custom de excepciones
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Excepcion de precio no encontrado
     * @param ex
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFounfException(Exception ex) {
        PriceNotFoundExceptionResponse errorResponse = new PriceNotFoundExceptionResponse("Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Excepcion de brandId no encontrado
     * @param ex
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler(BrandIdNotFoundException.class)
    public ResponseEntity<Object> handleBrandIdException(Exception ex) {
        PriceNotFoundExceptionResponse errorResponse = new PriceNotFoundExceptionResponse("Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Excepcion de productId no encontrado
     * @param ex
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<Object> handleProductIdException(Exception ex) {
        PriceNotFoundExceptionResponse errorResponse = new PriceNotFoundExceptionResponse("Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
