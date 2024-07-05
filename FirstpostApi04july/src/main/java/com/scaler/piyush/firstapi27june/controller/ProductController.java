package com.scaler.piyush.firstapi27june.controller;


import com.scaler.piyush.firstapi27june.dtos.CreateProductRequestDto;
import com.scaler.piyush.firstapi27june.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.scaler.piyush.firstapi27june.service.ProductService;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {


    private ProductService productService;

    private RestTemplate restTemplate;

    @Autowired
    public ProductController(ProductService productService, RestTemplate restTemplate){

        this.productService = productService;
        this.restTemplate = restTemplate;
    }





    //response body
    // {
    //        title:
    //        description:
    //        price:
    // }
    @PostMapping("/products") //spring knows whenever an http post request with this /products endpoints call this method.
    public Product createproduct(@RequestBody CreateProductRequestDto request){

        return productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImage()
        );


    }

    @GetMapping("/products/{id}")            // path variable
    public Product getProductDetails(@PathVariable("id")Long productId) {
        return productService.getSingleproduct(productId);




        // GET /products/1
        // GET /products/101

    }

    @GetMapping("/products")
    public void getAllProduct() {

    }

    @PutMapping("/products")
    public void updateProduct() {

    }


}
