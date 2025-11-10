package com.example.myapplication;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class yourapp extends AppCompatActivity {

    private CalendarView calendarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookingcalendarpatient); // your XML layout

        calendarView = findViewById(R.id.calendarView);

        // Create green/red circle shapes for events
        ShapeDrawable greenCircle = new ShapeDrawable(new OvalShape());
        greenCircle.getPaint().setColor(0xFF4CAF50); // Green

        ShapeDrawable redCircle = new ShapeDrawable(new OvalShape());
        redCircle.getPaint().setColor(0xFFF44336); // Red

        // Example event days
        List<EventDay> events = new ArrayList<>();

        Calendar availableDay = Calendar.getInstance();
        availableDay.set(2025, Calendar.NOVEMBER, 12); // green
        events.add(new EventDay(availableDay, greenCircle));

        Calendar unavailableDay = Calendar.getInstance();
        unavailableDay.set(2025, Calendar.NOVEMBER, 15); // red
        events.add(new EventDay(unavailableDay, redCircle));

        // Add events to calendar
        calendarView.setEvents(events);

        // Keep track of selected EventDay
        final EventDay[] selectedEvent = new EventDay[1];

        // Set the listener
        calendarView.setOnDayClickListener(eventDay -> {
            // Enable the book button
            findViewById(R.id.btnBook).setEnabled(true);

            // Store selected day
            selectedEvent[0] = eventDay;

            // Set the selection color
            try {
                calendarView.setDate(eventDay.getCalendar()); // Will throw OutOfDateRangeException if invalid
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}