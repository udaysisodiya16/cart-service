package com.capstone.cartservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {

    @NotBlank(message = "Product ID cannot be blank")
    private String productId;

    private String productName;

    @Positive(message = "Quantity must be greater than 0")
    private int quantity;

    @Positive(message = "Price must be greater than 0")
    private double price;

}
