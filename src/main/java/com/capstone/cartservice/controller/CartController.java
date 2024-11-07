package com.capstone.cartservice.controller;

import com.capstone.cartservice.dtos.CartDto;
import com.capstone.cartservice.dtos.CartItemDto;
import com.capstone.cartservice.mappers.CartMapper;
import com.capstone.cartservice.models.Cart;
import com.capstone.cartservice.services.ICartService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    private final CartMapper cartMapper = Mappers.getMapper(CartMapper.class);

    @GetMapping("/{userId}")
    public ResponseEntity<CartDto> viewCart(@PathVariable String userId) {
        Cart cart = cartService.getCart(userId);
        return ResponseEntity.ok(cartMapper.cartToCartDto(cart));
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<Boolean> addToCart(@PathVariable String userId, @RequestBody CartItemDto cartItemDto) {
        Cart.CartItem cartItem = cartMapper.cartItemDtoToCartItem(cartItemDto);
        Boolean status = cartService.addToCart(userId, cartItem);
        return ResponseEntity.ok(status);
    }
}

