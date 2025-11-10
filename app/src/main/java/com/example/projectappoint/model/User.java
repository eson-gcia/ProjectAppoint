// Create a new file: User.java in com.example.projectappoint.model
package com.example.projectappoint.model;

public class User {
    private String userId;
    private String fullName;
    private String email;
    private UserRole role;

    public User() {
        // Default constructor required for Firestore
    }

    public User(String userId, String fullName, String email, UserRole role) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

    // Getters and setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }
}