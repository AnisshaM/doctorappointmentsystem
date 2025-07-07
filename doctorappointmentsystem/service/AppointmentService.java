package com.example.doctorappointmentsystem.service;

import com.example.doctorappointmentsystem.dao.AppointmentRepository;
import com.example.doctorappointmentsystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public boolean isSlotAvailable(Doctor doctor, LocalDate date, LocalTime time) {
        if (doctor == null) return false;
        return appointmentRepository.findAll().stream()
                .noneMatch(app -> app.getDoctor() != null &&
                                     app.getDoctor().getId().equals(doctor.getId()) &&
                                     app.getDate().equals(date) &&
                                     app.getTime().equals(time));
    }

    public Appointment bookAppointment(Appointment appointment) {
        if (appointment.getDoctor() == null) throw new RuntimeException("Doctor is required");
        if (isSlotAvailable(appointment.getDoctor(), appointment.getDate(), appointment.getTime())) {
            appointment.setStatus("BOOKED");
            return appointmentRepository.save(appointment);
        }
        throw new RuntimeException("Slot not available");
    }

    public void cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus("CANCELLED");
        appointmentRepository.save(appointment);
    }

	public Object getAllAppointments() {
		// TODO Auto-generated method stub
		return null;
	}
}
