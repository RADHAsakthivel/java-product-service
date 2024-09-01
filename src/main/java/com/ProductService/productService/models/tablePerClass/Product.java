package com.ProductService.productService.models.tablePerClass;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "table_per_class_product")
public class Product extends Company {
    private String ProductName;
    private String description;
    private String category;
    private int price;
}

