package com.gamestoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gamestoreapp.entity.Order;
import com.gamestoreapp.entity.LibraryItem;
import com.gamestoreapp.serviceImpl.OrderService;

@RestController
@RequestMapping("/auth/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.placeOrder(
                request.getUserId(),
                request.getPaymentMethod(),
                request.getGameIds(),
                request.getTotalAmount()
        );
    }

    @GetMapping("/user/{userId}")
    public List<Order> getUserOrders(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @GetMapping("/library/{userId}")
    public List<LibraryItem> getUserLibrary(@PathVariable Long userId) {
        return orderService.getLibraryByUser(userId);
    }

    public static class OrderRequest {
        private Long userId;
        private String paymentMethod;
        private List<Long> gameIds;
        private Double totalAmount;

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public String getPaymentMethod() { return paymentMethod; }
        public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
        public List<Long> getGameIds() { return gameIds; }
        public void setGameIds(List<Long> gameIds) { this.gameIds = gameIds; }
        public Double getTotalAmount() { return totalAmount; }
        public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    }
}
