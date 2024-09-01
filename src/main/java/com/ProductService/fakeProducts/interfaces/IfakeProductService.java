package com.ProductService.fakeProducts.interfaces;

import com.ProductService.fakeProducts.dto.Products;
import org.springframework.http.ResponseEntity;

public interface IfakeProductService {
    ResponseEntity<Products[]> getProducts();
    ResponseEntity<Products> getProductById(long productId);
//    ResponseEntity<Products[]> getProductByCategory(String category);
//    ResponseEntity<Products[]> getProductByRatingsRange(short minRating, short maxRating);
}
