//package com.gamestoreapp.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "carts")
//public class Cart {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    
//    @ManyToOne
//    @JoinColumn(name = "game_id", nullable = false)
//    private Game game;
//    
//    @Column(nullable = false)
//    private Integer quantity = 1;
//    
//    public Cart() {}
//    
//    public Cart(User user, Game game) {
//        this.user = user;
//        this.game = game;
//    }
//    
//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//    
//    public Game getGame() { return game; }
//    public void setGame(Game game) { this.game = game; }
//    
//    public Integer getQuantity() { return quantity; }
//    public void setQuantity(Integer quantity) { this.quantity = quantity; }
//}
