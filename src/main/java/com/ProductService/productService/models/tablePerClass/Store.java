package com.ProductService.productService.models.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "table_per_class_store")
public class Store extends Company {
    private String wareHouseName;
    private String location;
    private String storeName;
}
