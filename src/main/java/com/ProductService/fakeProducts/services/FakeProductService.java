package com.ProductService.fakeProducts.services;

import com.ProductService.fakeProducts.dto.Products;
import com.ProductService.fakeProducts.interfaces.IfakeProductService;
import com.ProductService.shared.exceptions.ProductException;
import com.ProductService.shared.responses.ProductResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        //You can use RestTemplate from spring for api call it woul be very easy
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

    public ResponseEntity<Products> getProductById(long productId) throws ProductException {
        HttpRequest request = this.getRequestHandler(url,String.valueOf(productId));
        CompletableFuture<Products> responseFuture =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .thenApply(responseBody -> {
                            try {
                                Products product = mapper.readValue(responseBody, Products.class);
                                if(product != null){
                                    return product;
                                }else {
                                    return null;
                                }
                            } catch (Exception ex) {
                                return null;
                            }
                        });
        Products product =  responseFuture.join();
        if(product == null){
            throw new ProductException("Product id: " + productId + " not found");
        }
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