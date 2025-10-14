package com.gamestoreapp.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    
    private String transactionId;

    private Double totalAmount;

    private String paymentMethod;

    private LocalDateTime orderTime;

    public Order() {}

    public Order(Long userId, String transactionId, Double totalAmount, String paymentMethod, LocalDateTime orderTime) {
        this.userId = userId;
        this.transactionId = transactionId;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.orderTime = orderTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public LocalDateTime getOrderTime() { return orderTime; }
    public void setOrderTime(LocalDateTime orderTime) { this.orderTime = orderTime; }
}
