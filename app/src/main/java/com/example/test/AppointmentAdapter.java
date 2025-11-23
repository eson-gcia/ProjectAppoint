package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {

    private List<Appointment> appointments;
    private int selectedPosition = -1;
    private final OnAppointmentClickListener listener;
    private List<String> timeSlots;

    public interface OnAppointmentClickListener {
        void onAppointmentClick(int position, Appointment appointment);
    }

    public AppointmentAdapter(List<Appointment> appointments, OnAppointmentClickListener listener) {
        this.appointments = appointments;
        this.listener = listener;
        generateTimeSlots();
    }

    private void generateTimeSlots() {
        timeSlots = new ArrayList<>();
        // Generate time slots from 9 AM to 5 PM
        String[] amPm = {"A.M.", "P.M."};

        // 9 AM to 11 AM
        for (int hour = 9; hour <= 11; hour++) {
            timeSlots.add(hour + ":00 A.M.");
        }

        // 12 PM
        timeSlots.add("12:00 P.M.");

        // 1 PM to 5 PM
        for (int hour = 1; hour <= 5; hour++) {
            timeSlots.add(hour + ":00 P.M.");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appointment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Appointment appointment = appointments.get(position);
        holder.tvDate.setText(appointment.getDate());

        // Setup spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                holder.itemView.getContext(),
                android.R.layout.simple_spinner_item,
                timeSlots
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinnerTime.setAdapter(adapter);

        // Set default time
        int timeIndex = timeSlots.indexOf(appointment.getTime());
        if (timeIndex != -1) {
            holder.spinnerTime.setSelection(timeIndex);
        }

        holder.spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                appointment.setTime(timeSlots.get(pos));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        holder.itemView.setOnClickListener(v -> {
            int previousPosition = selectedPosition;
            selectedPosition = holder.getAdapterPosition();

            if (previousPosition != -1) {
                notifyItemChanged(previousPosition);
            }
            notifyItemChanged(selectedPosition);

            // Silent selection - no toast notification
            if (listener != null) {
                listener.onAppointmentClick(selectedPosition, appointment);
            }
        });

        if (position == selectedPosition) {
            holder.itemView.setBackgroundResource(R.drawable.appointment_item_selected);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.appointment_item_background);
        }
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public void updateAppointments(List<Appointment> newAppointments) {
        this.appointments = newAppointments;
        this.selectedPosition = -1;
        notifyDataSetChanged();
    }

    public Appointment getSelectedAppointment() {
        if (selectedPosition != -1 && selectedPosition < appointments.size()) {
            return appointments.get(selectedPosition);
        }
        return null;
    }

    public void clearSelection() {
        int previousPosition = selectedPosition;
        selectedPosition = -1;
        if (previousPosition != -1) {
            notifyItemChanged(previousPosition);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        Spinner spinnerTime;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            spinnerTime = itemView.findViewById(R.id.spinnerTime);
        }
    }
}