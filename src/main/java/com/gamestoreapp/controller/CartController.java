package com.gamestoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gamestoreapp.dto.CartItemDTO;
import com.gamestoreapp.entity.CartItem;
import com.gamestoreapp.serviceImpl.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/user/{userId}")
    public List<CartItemDTO> getCart(@PathVariable Long userId) {
        return cartService.getCart(userId);
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long userId, @RequestParam Long gameId) {
        return cartService.addToCart(userId, gameId);
    }

    @DeleteMapping("/remove")
    public void removeFromCart(@RequestParam Long userId, @RequestParam Long gameId) {
        cartService.removeFromCart(userId, gameId);
    }

    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<String> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared");
    }
}
