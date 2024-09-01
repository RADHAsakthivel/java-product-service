package com.ProductService.shared.responses;

import com.ProductService.fakeProducts.dto.Products;
import lombok.Getter;
import lombok.Setter;

public class ProductResponse {
    private Products[] products;
    @Getter
    @Setter
    private int total;
    @Getter
    @Setter
    private int skip;
    @Getter
    @Setter
    private int limit;
    
    public Products[] getProducts() {
        return products;
    }
    
    public void setProducts(Products[] products) {
        this.products = products;
    }
}
