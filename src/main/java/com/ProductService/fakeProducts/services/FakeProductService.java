package com.ProductService.fakeProducts.services;

import com.ProductService.fakeProducts.dto.Products;
import com.ProductService.fakeProducts.interfaces.IfakeProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@Service
public class FakeProductService implements IfakeProductService {
    HttpClient client = HttpClient.newHttpClient();
    final String url = "https://dummyjson.com/products";
    ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public ResponseEntity<Products[]> getProducts() {
        HttpRequest request = this.getRequestHandler(url);
        CompletableFuture<Products[]> responseFuture =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .thenApply(responseBody -> {
                            try {
                                ProductResponse productResponse = mapper.readValue(responseBody, ProductResponse.class);
                                return productResponse.getProducts();
                            } catch (Exception ex) {
                                return new Products[0];
                            }
                        });
        Products[] productsList = responseFuture.join();
        return new ResponseEntity<>(productsList,HttpStatus.OK);
    }

    public ResponseEntity<Products> getProductById(long productId){
        HttpRequest request = this.getRequestHandler(url,String.valueOf(productId));
        CompletableFuture<Products> responseFuture =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .thenApply(responseBody -> {
                            try {
                                return mapper.readValue(responseBody, Products.class);
                            } catch (Exception ex) {
                                return new Products();
                            }
                        });
        Products product = responseFuture.join();
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    private HttpRequest getRequestHandler(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    private HttpRequest getRequestHandler(String url,String params){
        return HttpRequest.newBuilder()
                .uri(URI.create(url+"/"+params))
                .build();
    }

}

class ProductResponse {
    private Products[] products;
    @Getter
    @Setter
    private int total;
    @Getter
    @Setter
    private int skip;
    @Getter
    @Setter
    private int limit;

    public Products[] getProducts() {
        return products;
    }

    public void setProducts(Products[] products) {
        this.products = products;
    }
}