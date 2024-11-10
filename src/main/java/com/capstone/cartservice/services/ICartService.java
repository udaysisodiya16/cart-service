package com.capstone.cartservice.services;

import com.capstone.cartservice.models.Cart;

public interface ICartService {

    Cart getCart(String userId);

    Cart addToCart(String userId, Cart.CartItem item);

    Boolean clearCart(String userId);

}
