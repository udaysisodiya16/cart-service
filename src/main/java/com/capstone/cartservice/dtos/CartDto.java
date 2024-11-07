package com.capstone.cartservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDto {

    private List<CartItemDto> items;

    private double total;

}
