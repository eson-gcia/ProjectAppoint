package com.example.projectappoint.model;

import java.util.Date;

public class Appointment {
    private String appointmentId;
    private String therapistId;
    private String patientId;
    private Date date;
    private String timeSlot;
    private String status; // Scheduled, Pending, Rescheduled, Cancelled
    private String meetingLink;

    public Appointment() {}

    public Appointment(String appointmentId, String therapistId, String patientId, Date date, String timeSlot,
                       String status, String meetingLink) {
        this.appointmentId = appointmentId;
        this.therapistId = therapistId;
        this.patientId = patientId;
        this.date = date;
        this.timeSlot = timeSlot;
        this.status = status;
        this.meetingLink = meetingLink;
    }

    // Getters and setters
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getTherapistId() { return therapistId; }
    public void setTherapistId(String therapistId) { this.therapistId = therapistId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMeetingLink() { return meetingLink; }
    public void setMeetingLink(String meetingLink) { this.meetingLink = meetingLink; }
}
