package com.scaler.piyush.firstapi27june.service;
import com.scaler.piyush.firstapi27june.dtos.CreateProductRequestDto;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scaler.piyush.firstapi27june.dtos.FakeStoreProductDto;
import com.scaler.piyush.firstapi27june.model.Product;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    // RestTemplate
    // allows to send https requests to external URLs
    // and work with responses

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }


    @Override
    public Product getSingleproduct(Long productId) {
        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class);
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 String category,
                                 Double price,
                                 String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setDescription(description);

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products", // url
                fakeStoreProductDto, // request body
                FakeStoreProductDto.class // data type of response
        );

        if (response == null) return new Product();

        return response.toProduct();
    }
}


