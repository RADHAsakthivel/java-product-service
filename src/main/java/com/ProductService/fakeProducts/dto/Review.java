package com.ProductService.fakeProducts.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
    int rating;
    String comment;
    String date;
    String reviewerName;
    String reviewerEmail;
}
