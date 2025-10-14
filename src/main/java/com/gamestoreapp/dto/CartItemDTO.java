//package com.gamestoreapp.dto;
//
//public class CartItemDTO {
//    private Long id;
//    private Long gameId;
//    private String gameName;
//    private String imgBase64;
//    private Double price;
//    private Double discount;
//
//    public CartItemDTO() {}
//
//    public CartItemDTO(Long id, Long gameId, String gameName, String imgBase64, Double price, Double discount) {
//        this.id = id;
//        this.gameId = gameId;
//        this.gameName = gameName;
//        this.imgBase64 = imgBase64;
//        this.price = price;
//        this.discount = discount;
//    }
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Long getGameId() {
//		return gameId;
//	}
//
//	public void setGameId(Long gameId) {
//		this.gameId = gameId;
//	}
//
//	public String getGameName() {
//		return gameName;
//	}
//
//	public void setGameName(String gameName) {
//		this.gameName = gameName;
//	}
//
//	public String getImgBase64() {
//		return imgBase64;
//	}
//
//	public void setImgBase64(String imgBase64) {
//		this.imgBase64 = imgBase64;
//	}
//
//	public Double getPrice() {
//		return price;
//	}
//
//	public void setPrice(Double price) {
//		this.price = price;
//	}
//
//	public Double getDiscount() {
//		return discount;
//	}
//
//	public void setDiscount(Double discount) {
//		this.discount = discount;
//	}
//}







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
