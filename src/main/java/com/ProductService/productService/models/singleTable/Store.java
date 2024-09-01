package com.ProductService.productService.models.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.*;

@Data
@Entity(name = "single_table_store")
@DiscriminatorValue("st_store")
public class Store extends Company {
    private String wareHouseName;
    private String location;
    private String storeName;
    
    @ManyToMany(mappedBy = "stores")
    private Set<Product> products;
}
