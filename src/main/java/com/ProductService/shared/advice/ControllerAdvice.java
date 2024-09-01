package com.ProductService.shared.advice;

import com.ProductService.shared.exceptions.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice

public class ControllerAdvice {
    
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<String> handleProductException(ProductException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
