package com.gamestoreapp.dto;

public class CartItemDTO {
    private Long id;
    private Long gameId;
    private String name;
    private Double price;
    private Double discount;
    private String imgBase64;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getGameId() { return gameId; }
    public void setGameId(Long gameId) { this.gameId = gameId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getDiscount() { return discount; }
    public void setDiscount(Double discount) { this.discount = discount; }

    public String getImgBase64() { return imgBase64; }
    public void setImgBase64(String imgBase64) { this.imgBase64 = imgBase64; }
}
