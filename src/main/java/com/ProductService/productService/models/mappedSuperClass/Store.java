package com.ProductService.productService.models.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Store extends Company {
    private String wareHouseName;
    private String location;
    private String storeName;
}
