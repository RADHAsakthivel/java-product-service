package com.ProductService.productService.models.singleTable;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "single_table_company")
@DiscriminatorColumn(name = "entity_type", discriminatorType = DiscriminatorType.STRING)
public class Company {
    @Id
    private UUID id;
    private String companyName;
    private String companyAddress;
    private String companyPhone;
    private String companyEmail;
}
