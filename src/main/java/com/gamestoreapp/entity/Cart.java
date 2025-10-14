//package com.gamestoreapp.entity;
//
//import jakarta.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//


//
//@Entity
//@Table(name = "carts")
//public class Cart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CartItem> items = new ArrayList<>();
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @Column(nullable = false)
//    private String userName;
//
//    @Column(nullable = false)
//    private String userEmail;
//
//    @Column(nullable = false)
//    private double totalPrice;
//
//    public Cart() {}
//
//    public Cart(User user) {
//        this.user = user;
//        this.userName = user.getFirstName();
//        this.userEmail = user.getEmail();
//        this.totalPrice = 0;
//    }
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public List<CartItem> getItems() { return items; }
//    public void setItems(List<CartItem> items) { this.items = items; }
//
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//
//    public String getUserName() { return userName; }
//    public void setUserName(String userName) { this.userName = userName; }
//
//    public String getUserEmail() { return userEmail; }
//    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
//
//    public double getTotalPrice() { return totalPrice; }
//    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
//}





























//
//
//package com.gamestoreapp.entity;
//
//import jakarta.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "carts")
//public class Cart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CartItem> items = new ArrayList<>();
//
//    @Column(nullable = false)
//    private double totalPrice = 0;
//
//    public Cart() {}
//    
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//
//    public List<CartItem> getItems() { return items; }
//    public void setItems(List<CartItem> items) { this.items = items; }
//
//    public double getTotalPrice() { return totalPrice; }
//    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
//
//	public Cart(Long id, User user, List<CartItem> items, double totalPrice) {
//		super();
//		this.id = id;
//		this.user = user;
//		this.items = items;
//		this.totalPrice = totalPrice;
//	}
//    
//    
//}






































//
//
//// Cart.java
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
