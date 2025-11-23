package com.example.test;

import java.util.Calendar;

public class Appointment {
    private final String date;
    private String time;
    private final Calendar calendar;

    public Appointment(String date, String time, Calendar calendar) {
        this.date = date;
        this.time = time;
        this.calendar = calendar;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Calendar getCalendar() {
        return calendar;
    }

}