package com.example.projectappoint.model;

import java.util.List;

public class Availability {
    private List<String> workingDays;
    private String startTime;
    private String endTime;
    private List<String> blockedDates;

    public Availability() {}

    public Availability(List<String> workingDays, String startTime, String endTime, List<String> blockedDates) {
        this.workingDays = workingDays;
        this.startTime = startTime;
        this.endTime = endTime;
        this.blockedDates = blockedDates;
    }

    // Getters and setters
    public List<String> getWorkingDays() { return workingDays; }
    public void setWorkingDays(List<String> workingDays) { this.workingDays = workingDays; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public List<String> getBlockedDates() { return blockedDates; }
    public void setBlockedDates(List<String> blockedDates) { this.blockedDates = blockedDates; }
}
