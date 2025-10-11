package com.gamestoreapp.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Name of the user for this address

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String houseNo;

    @Column(nullable = false)
    private String street;

    private String landmark;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private Long userId; // Just store the user ID, no mapping
    
    public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(Long id, String name, String phoneNumber, String houseNo, String street, String landmark,
			String city, String zipCode, Long userId) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.houseNo = houseNo;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.zipCode = zipCode;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
}

