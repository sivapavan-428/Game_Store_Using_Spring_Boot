package com.gamestoreapp.dto;

public class UserDTO {
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;

    
    public UserDTO() {
   	}
   	
    
	public UserDTO(Long id, String firstName,String lastName, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


   
}
