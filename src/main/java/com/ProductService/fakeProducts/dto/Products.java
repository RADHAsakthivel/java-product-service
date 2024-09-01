package com.ProductService.fakeProducts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
    long id;
    String title;
    String description;
    String category;
    double price;
    double discountPercentage;
    double rating;
    int stock;
    String[] tags;
    String brand;
    String sku;
    int weight;
    Dimension dimensions;
    String warrantyInformation;
    String shippingInformation;
    String availabilityStatus;
    Review[] reviews;
    String returnPolicy;
    int minimumOrderQuantity;
    ProductMeta meta;
    String[] images;
    String thumbnail;
}
