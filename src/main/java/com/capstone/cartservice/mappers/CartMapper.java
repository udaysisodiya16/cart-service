package com.capstone.cartservice.mappers;

import com.capstone.cartservice.dtos.CartDto;
import com.capstone.cartservice.dtos.CartItemDto;
import com.capstone.cartservice.models.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartDto cartToCartDto(Cart cart);

    Cart.CartItem cartItemDtoToCartItem(CartItemDto cartItemDto);
}
