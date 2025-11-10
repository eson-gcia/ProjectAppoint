package com.example.projectappoint.model;

import java.util.Date;

public class SessionNote {
    private String noteId;
    private String therapistId;
    private String patientId;
    private String noteContent;
    private Date createdAt;
    private Date updatedAt;

    public SessionNote() {}

    public SessionNote(String noteId, String therapistId, String patientId, String noteContent, Date createdAt, Date updatedAt) {
        this.noteId = noteId;
        this.therapistId = therapistId;
        this.patientId = patientId;
        this.noteContent = noteContent;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and setters
    public String getNoteId() { return noteId; }
    public void setNoteId(String noteId) { this.noteId = noteId; }

    public String getTherapistId() { return therapistId; }
    public void setTherapistId(String therapistId) { this.therapistId = therapistId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getNoteContent() { return noteContent; }
    public void setNoteContent(String noteContent) { this.noteContent = noteContent; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
