package com.ProductService.productService.models.mappedSuperClass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.UUID;

@Data
@MappedSuperclass
public class Company {
    @Id
    private UUID id;
    private String companyName;
    private String companyAddress;
    private String companyPhone;
    private String companyEmail;
}
