package com.ProductService.productService.models.joinTabel;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "join_companies")
public class Company {
    @Id
    private UUID id;
    private String companyName;
    private String companyAddress;
    private String companyPhone;
    private String companyEmail;
}
