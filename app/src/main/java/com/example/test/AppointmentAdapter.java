package com.example.test;

import android.annotation.SuppressLint;
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
    private final List<String> timeSlots;

    public interface OnAppointmentClickListener {
        void onAppointmentClick(int position, Appointment appointment);
    }

    public AppointmentAdapter(List<Appointment> appointments, OnAppointmentClickListener listener) {
        this.appointments = appointments;
        this.listener = listener;
        this.timeSlots = generateTimeSlots();
    }

    private List<String> generateTimeSlots() {
        List<String> slots = new ArrayList<>();

        // 9 AM - 11 AM
        for (int hour = 9; hour <= 11; hour++) {
            slots.add(hour + ":00 A.M.");
        }

        // 12 PM
        slots.add("12:00 P.M.");

        // 1 PM - 5 PM
        for (int hour = 1; hour <= 5; hour++) {
            slots.add(hour + ":00 P.M.");
        }

        return slots;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appointment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Appointment appointment = appointments.get(position);
        holder.tvDate.setText(appointment.getDate());

        // Spinner setup
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                holder.itemView.getContext(),
                android.R.layout.simple_spinner_item,
                timeSlots
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinnerTime.setAdapter(adapter);

        // Set spinner default value
        int timeIndex = timeSlots.indexOf(appointment.getTime());
        if (timeIndex != -1) holder.spinnerTime.setSelection(timeIndex);

        holder.spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                int currentPos = holder.getBindingAdapterPosition();
                if (currentPos == RecyclerView.NO_POSITION) return;

                appointments.get(currentPos).setTime(timeSlots.get(pos));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        // Click listener
        holder.itemView.setOnClickListener(v -> {
            int currentPos = holder.getBindingAdapterPosition();
            if (currentPos == RecyclerView.NO_POSITION) return;

            int previous = selectedPosition;
            selectedPosition = currentPos;

            if (previous != -1) notifyItemChanged(previous);
            notifyItemChanged(selectedPosition);

            if (listener != null) {
                listener.onAppointmentClick(selectedPosition, appointments.get(selectedPosition));
            }
        });


        // Highlight selected item
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

    @SuppressLint("NotifyDataSetChanged")
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
        int previous = selectedPosition;
        selectedPosition = -1;
        if (previous != -1) notifyItemChanged(previous);
    }

    // FIX: Make it PUBLIC
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        Spinner spinnerTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            spinnerTime = itemView.findViewById(R.id.spinnerTime);
        }
    }
}
