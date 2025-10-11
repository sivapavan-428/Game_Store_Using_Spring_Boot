package com.gamestoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gamestoreapp.entity.Cart;
import com.gamestoreapp.entity.CartItem;
import com.gamestoreapp.serviceImpl.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Get cart by user ID
    @GetMapping("/user/{userId}")
    public Cart getCartByUser(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    // Add item to cart
    @PostMapping("/{cartId}/add")
    public Cart addItem(@PathVariable Long cartId, @RequestBody CartItem item) {
        return cartService.addGameToCart(cartId, item);
    }

    // Remove item from cart
    @DeleteMapping("/{cartId}/remove/{itemId}")
    public String removeItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        cartService.removeItemFromCart(cartId, itemId);
        return "Item removed";
    }

    // Clear cart for a specific user
    @DeleteMapping("/clear/{userId}")
    public String clearCart(@PathVariable Long userId) {
        cartService.clearCartByUser(userId);
        return "Cart cleared";
    }
}
