package com.gamestoreapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    
    @Column(name = "house_no", nullable = false)
    private String house;
    private String landmark;
    private String street;
    private String city;
    private String zip;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Address() {}

    public Address(Long id, String name, String phone, String house, String landmark,
                   String street, String city, String zip, User user) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.house = house;
        this.landmark = landmark;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.user = user;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getHouse() { return house; }
    public void setHouse(String house) { this.house = house; }
    public String getLandmark() { return landmark; }
    public void setLandmark(String landmark) { this.landmark = landmark; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
