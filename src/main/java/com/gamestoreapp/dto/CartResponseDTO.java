// CartResponseDTO.java
package com.gamestoreapp.dto;

public class CartResponseDTO {
    private Long id;
    private Long userId;
    private GameDTO game;
    private Integer quantity;
    
    // Default constructor
    public CartResponseDTO() {}
    
    // Parameterized constructor
    public CartResponseDTO(Long id, Long userId, GameDTO game, Integer quantity) {
        this.id = id;
        this.userId = userId;
        this.game = game;
        this.quantity = quantity;
    }
    
    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public Long getUserId() { 
        return userId; 
    }
    
    public void setUserId(Long userId) { 
        this.userId = userId; 
    }
    
    public GameDTO getGame() { 
        return game; 
    }
    
    public void setGame(GameDTO game) { 
        this.game = game; 
    }
    
    public Integer getQuantity() { 
        return quantity; 
    }
    
    public void setQuantity(Integer quantity) { 
        this.quantity = quantity; 
    }
}