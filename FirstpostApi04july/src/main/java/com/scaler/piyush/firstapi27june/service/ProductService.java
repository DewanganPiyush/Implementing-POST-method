package com.scaler.piyush.firstapi27june.service;

import com.scaler.piyush.firstapi27june.model.Product;

import java.util.List;

public interface ProductService {

      Product getSingleproduct(Long productId);



     List<Product> getProducts();

     Product createProduct();

    Product createProduct(String title,
                          String description,
                          String category,
                          Double price,
                          String image);








}
