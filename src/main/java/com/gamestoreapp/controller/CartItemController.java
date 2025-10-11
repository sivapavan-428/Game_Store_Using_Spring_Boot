package com.gamestoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gamestoreapp.entity.CartItem;
import com.gamestoreapp.serviceImpl.CartItemService;

@RestController
@RequestMapping("/cart-item")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    // Add item to cart
    @PostMapping("/add")
    public CartItem addItem(@RequestBody CartItem item) {
        return cartItemService.addCartItem(item);
    }

    // Update quantity of a cart item
    @PatchMapping("/update/{itemId}")
    public CartItem updateItemQuantity(@PathVariable Long itemId, @RequestParam int quantity) {
        return cartItemService.updateCartItemQuantity(itemId, quantity);
    }

    // Remove item from cart
    @DeleteMapping("/remove/{itemId}")
    public String removeItem(@PathVariable Long itemId) {
        cartItemService.removeItem(itemId);
        return "Item removed from cart";
    }

    // Get all items in a user's cart
    @GetMapping("/all/{userId}")
    public List<CartItem> getItemsByUser(@PathVariable Long userId) {
        return cartItemService.getCartItemsByUserId(userId);
    }

    // Get single cart item by ID
    @GetMapping("/{itemId}")
    public CartItem getItemById(@PathVariable Long itemId) {
        return cartItemService.getCartItemById(itemId);
    }
}
