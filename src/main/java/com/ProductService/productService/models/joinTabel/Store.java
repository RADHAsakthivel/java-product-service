package com.ProductService.productService.models.joinTabel;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "join_stores")
@PrimaryKeyJoinColumn(name = "company_id")
public class Store extends Company {
    private String wareHouseName;
    private String location;
    private String storeName;
}
