package com.gamestoreapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestoreapp.entity.CartItem;
import com.gamestoreapp.entity.Game;
import com.gamestoreapp.entity.User;
import com.gamestoreapp.repository.CartRepository;
import com.gamestoreapp.repository.GameRepository;
import com.gamestoreapp.repository.UserRepository;
import com.gamestoreapp.dto.CartItemDTO;
import com.gamestoreapp.dto.GameDTO;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    public List<CartItemDTO> getCart(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<CartItem> cartItems = cartRepository.findByUser(user);

        return cartItems.stream().map(item -> {
            CartItemDTO dto = new CartItemDTO();
            dto.setId(item.getId());
            dto.setGameId(item.getGame().getId());
            dto.setName(item.getGame().getName());
            dto.setPrice(item.getGame().getPrice());
            dto.setDiscount(item.getGame().getDiscount());
            dto.setImgBase64(item.getGame().getImgBase64());
            return dto;
        }).toList();
    }


    public CartItem addToCart(Long userId, Long gameId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        if (cartRepository.findByUserAndGame(user, game).isPresent()) {
            throw new RuntimeException("Game already in cart");
        }

        CartItem cartItem = new CartItem(user, game);
        return cartRepository.save(cartItem);
    }

    public void removeFromCart(Long userId, Long gameId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        CartItem cartItem = cartRepository.findByUserAndGame(user, game)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        cartRepository.delete(cartItem);
    }

    public void clearCart(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        cartRepository.deleteByUser(user);
    }
}
