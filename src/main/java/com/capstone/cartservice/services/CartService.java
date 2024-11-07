package com.capstone.cartservice.services;

import com.capstone.cartservice.models.Cart;
import com.capstone.cartservice.repos.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RedisTemplate<String, Cart> redisTemplate;

    private static final String CART_PREFIX = "cart:";

    @Override
    public Cart getCart(String userId) {
        String redisKey = CART_PREFIX + userId;
        Cart cart = redisTemplate.opsForValue().get(redisKey);

        if (cart == null) {
            cart = cartRepository.findById(userId).orElse(new Cart());
            redisTemplate.opsForValue().set(redisKey, cart, 1, TimeUnit.HOURS);
        }
        return cart;
    }

    @Override
    public Boolean addToCart(String userId, Cart.CartItem item) {
        Cart cart = getCart(userId);
        cart.getItems().removeIf(i -> i.getProductId().equals(item.getProductId())); // Remove if exists
        cart.getItems().add(item);
        cart.setTotal(cart.getItems().stream().mapToDouble(i -> i.getQuantity() * i.getPrice()).sum());
        cartRepository.save(cart);
        redisTemplate.opsForValue().set(CART_PREFIX + userId, cart, 1, TimeUnit.HOURS);
        return true;
    }

    @Override
    public Boolean clearCart(String userId) {
        cartRepository.deleteById(userId);
        redisTemplate.delete(CART_PREFIX + userId);
        return true;
    }
}
