//package com.gamestoreapp.dto;
//
//public class LoginResponse {
//    private Long userId; 
//    private String email;
//    private String firstName;
//    private String lastName;
//    
//    public LoginResponse() {}
//    
//    public Long getUserId() { return userId; }
//    public void setUserId(Long userId) { this.userId = userId; }
//    
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//    
//    public String getFirstName() { return firstName; }
//    public void setFirstName(String firstName) { this.firstName = firstName; }
//    
//    public String getLastName() { return lastName; }
//    public void setLastName(String lastName) { this.lastName = lastName; }
//}















package com.gamestoreapp.dto;

public class LoginResponse {
    private Long userId; 
    private String email;
    private String firstName;
    private String lastName;
    private String role;    // new
    private String token;   // new

    public LoginResponse() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getRole() { return role; }       // getter
    public void setRole(String role) { this.role = role; } // setter

    public String getToken() { return token; }     // getter
    public void setToken(String token) { this.token = token; } // setter
}
