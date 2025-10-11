package com.gamestoreapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.gamestoreapp.entity.Cart;
import com.gamestoreapp.entity.CartItem;
import com.gamestoreapp.entity.Game;
import com.gamestoreapp.entity.User;
import com.gamestoreapp.repository.CartRepository;
import com.gamestoreapp.repository.GameRepository;
import com.gamestoreapp.repository.UserRepository;
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart addGameToCart(Long userId, Long gameId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> new Cart(user));

        boolean exists = cart.getItems().stream()
                .anyMatch(item -> item.getGame().getId().equals(gameId));

        if (!exists) {
            CartItem newItem = new CartItem(game, cart);
            cart.getItems().add(newItem);
        }

        // update total price
        double total = cart.getItems().stream()
                .mapToDouble(item -> {
                    Double discount = item.getGame().getDiscount();
                    double discountedPrice = (discount != null)
                            ? item.getGame().getPrice() - (item.getGame().getPrice() * discount / 100)
                            : item.getGame().getPrice();
                    return discountedPrice;
                })
                .sum();

        cart.setTotalPrice(total);
        return cartRepository.save(cart);
    }

    public Cart removeGameFromCart(Long userId, Long gameId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        cart.getItems().removeIf(item -> item.getGame().getId().equals(gameId));

     
        double total = cart.getItems().stream()
                .mapToDouble(item -> {
                    Double discount = item.getGame().getDiscount();
                    double discountedPrice = (discount != null)
                            ? item.getGame().getPrice() - (item.getGame().getPrice() * discount / 100)
                            : item.getGame().getPrice();
                    return discountedPrice;
                })
                .sum();

        cart.setTotalPrice(total);
        return cartRepository.save(cart);
    }

    public Cart getCartByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }
}