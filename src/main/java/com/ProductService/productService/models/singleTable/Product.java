package com.ProductService.productService.models.singleTable;


import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity(name = "single_table_product")
@DiscriminatorValue("st_product")
public class Product extends Company {
    private String ProductName;
    private String description;
    private String category;
    private int price;
    
    @ManyToMany
    @JoinTable(
            name = "product_store",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id")
    )
    private Set<Store> stores;
}

