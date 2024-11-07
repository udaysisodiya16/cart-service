package com.capstone.cartservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {

    private String productId;

    private String productName;

    private int quantity;

    private double price;

}
