package com.example.projectappoint.model;

/**
 * Represents the different user roles in the application.
 * Defines access levels and permissions for each role.
 */
public enum UserRole {
    /**
     * Administrative user with full system access.
     * Can manage users, view all appointments, and access system settings.
     */
    ADMIN,
    
    /**
     * Therapist user who provides services.
     * Can manage their own schedule, view their appointments, and access patient records.
     */
    THERAPIST,
    
    /**
     * Standard patient user.
     * Can book appointments, view their own history, and manage their profile.
     */
    PATIENT;
    
    /**
     * Checks if this role has admin privileges.
     * @return true if the role is ADMIN, false otherwise
     */
    public boolean isAdmin() {
        return this == ADMIN;
    }
    
    /**
     * Checks if this role has therapist privileges.
     * @return true if the role is THERAPIST, false otherwise
     */
    public boolean isTherapist() {
        return this == THERAPIST;
    }
    
    /**
     * Checks if this role has patient privileges.
     * @return true if the role is PATIENT, false otherwise
     */
    public boolean isPatient() {
        return this == PATIENT;
    }

    /**
     * Converts a string to a UserRole enum value (case-insensitive).
     * 
     * @param role The string representation of the role
     * @return The corresponding UserRole, or null if no match is found
     */
    public static UserRole fromString(String role) {
        if (role == null) {
            return null;
        }
        try {
            return UserRole.valueOf(role.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
