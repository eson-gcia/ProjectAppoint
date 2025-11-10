package com.example.projectappoint.model;

public class Patient extends User {
    private String assignedTherapistId;
    private String condition;

    public Patient() {
        super();
        setRole(UserRole.PATIENT);
    }

    public Patient(String userId, String fullName, String email, String assignedTherapistId, String condition) {
        super(userId, fullName, email, UserRole.PATIENT);
        this.assignedTherapistId = assignedTherapistId;
        this.condition = condition;
    }

    public String getAssignedTherapistId() { return assignedTherapistId; }
    public void setAssignedTherapistId(String assignedTherapistId) { this.assignedTherapistId = assignedTherapistId; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
}
