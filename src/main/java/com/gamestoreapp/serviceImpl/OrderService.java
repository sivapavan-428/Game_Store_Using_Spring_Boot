package com.gamestoreapp.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestoreapp.entity.LibraryItem;
import com.gamestoreapp.entity.Order;
import com.gamestoreapp.entity.Game;
import com.gamestoreapp.repository.LibraryRepository;
import com.gamestoreapp.repository.OrderRepository;
import com.gamestoreapp.repository.GameRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private GameRepository gameRepository;

    public Order placeOrder(Long userId, String paymentMethod, List<Long> gameIds, Double totalAmount) {
     
        String transactionId = UUID.randomUUID().toString();

        Order order = new Order(userId, transactionId, totalAmount, paymentMethod, LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);

        for (Long gameId : gameIds) {
            Game game = gameRepository.findById(gameId)
                    .orElseThrow(() -> new RuntimeException("Game not found with ID: " + gameId));
            LibraryItem libraryItem = new LibraryItem(userId, game.getId(), game.getName());
            libraryRepository.save(libraryItem);
        }

        return savedOrder;
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findAll()
                .stream()
                .filter(order -> order.getUserId().equals(userId))
                .toList();
    }

    public List<LibraryItem> getLibraryByUser(Long userId) {
        return libraryRepository.findByUserId(userId);
    }
}
