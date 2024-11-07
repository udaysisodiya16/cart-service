package com.capstone.cartservice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "carts")
public class Cart {
    @Id
    private String userId; // Unique cart for each user
    private List<CartItem> items;
    private double total;

    public Cart() {
    }

    public Cart(String userId, List<CartItem> items, double total) {
        this.userId = userId;
        this.items = items;
        this.total = total;
    }

    // Nested CartItem class
    @Getter
    @Setter
    public static class CartItem {
        private String productId;
        private String productName;
        private int quantity;
        private double price;
    }
}

