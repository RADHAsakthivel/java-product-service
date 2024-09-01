package com.ProductService.productService.models.mappedSuperClass;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Product extends Company {
    private String ProductName;
    private String description;
    private String category;
    private int price;
}

