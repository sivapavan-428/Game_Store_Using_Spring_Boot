package com.gamestoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gamestoreapp.entity.Order;
import com.gamestoreapp.serviceImpl.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Get all orders of a specific user
    @GetMapping("/all/{userId}")
    public List<Order> getUserOrders(){
        return orderService.getAllOrders();
    }

    // Place a new order
//    @PostMapping("/place")
//    public Order placeOrder(@RequestBody Order order){
//        return orderService.placeOrder(order);
//    }

    // Cancel an order by ID
    @DeleteMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable Long id){
        orderService.cancelOrder(id);
        return "Order cancelled";
    }
}
