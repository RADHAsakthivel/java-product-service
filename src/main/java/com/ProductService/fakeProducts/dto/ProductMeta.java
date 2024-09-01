package com.ProductService.fakeProducts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductMeta {
    String createdAt;
    String updatedAt;
    String barcode;
    String qrCode;
}
