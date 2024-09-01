package com.ProductService.productService.models.joinTabel;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "join_products")
@PrimaryKeyJoinColumn(name = "company_id")
public class Product extends Company {
    private String ProductName;
    private String description;
    private String category;
    private int price;
}

