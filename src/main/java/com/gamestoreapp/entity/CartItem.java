package com.gamestoreapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(nullable = false)
    private String gameName; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

  

    public CartItem() {}

    public CartItem(Game game, Cart cart) {
        this.game = game;
        this.gameName = game.getName();
        this.cart = cart;   
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Game getGame() { return game; }
    public void setGame(Game game) { 
        this.game = game; 
        this.gameName = game.getName(); 
    }

    public String getGameName() { return gameName; }
    public void setGameName(String gameName) { this.gameName = gameName; }

    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }
    
}
