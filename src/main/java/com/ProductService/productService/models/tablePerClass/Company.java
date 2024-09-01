package com.ProductService.productService.models.tablePerClass;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "table_per_class_company")
public class Company {
    @Id
    private UUID id;
    private String companyName;
    private String companyAddress;
    private String companyPhone;
    private String companyEmail;
}
