package com.ProductService.fakeProducts.controllers;

import com.ProductService.fakeProducts.dto.Products;
import com.ProductService.fakeProducts.services.FakeProductService;
import com.ProductService.shared.exceptions.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fake-product")
public class FakeProductController {
    private final FakeProductService fakeProductService;

    public FakeProductController(FakeProductService fakeProductService){
        this.fakeProductService = fakeProductService;
    }

    @GetMapping("")
    public ResponseEntity<Products[]> getProducts(){
        return this.fakeProductService.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable long id) throws ProductException {
        return this.fakeProductService.getProductById(id);
    }
}
