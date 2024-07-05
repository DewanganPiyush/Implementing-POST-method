package com.scaler.piyush.firstapi27june.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {

    private String title;
    private String image;
    private String description;
    private String category;
    private double price;


}

// Dto for each request so that in future
// if the request needs additional parameters
// you can easily add without impact anything else

