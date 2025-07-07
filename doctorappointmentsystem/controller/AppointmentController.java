package com.example.doctorappointmentsystem.controller;

import com.example.doctorappointmentsystem.dao.*;
import com.example.doctorappointmentsystem.model.*;
import com.example.doctorappointmentsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/appointments/new")
    public String showForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("doctors", doctorRepository.findAll());
        return "appointmentForm";
    }

    @PostMapping("/appointments")
    public String book(@ModelAttribute Appointment appointment) {
        appointmentService.bookAppointment(appointment);
        return "redirect:/appointments";
    }
    
    
    @PostMapping
    public String book1(@ModelAttribute Appointment appointment) {
        // Extract doctor ID from the form
        Long doctorId = appointment.getDoctor().getId();

        // Fetch the managed doctor object from DB
        Doctor doctor = doctorRepository.findById(doctorId)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid doctor ID"));

        // Set the managed doctor instance
        appointment.setDoctor(doctor);

        // Now save the appointment safely
        appointmentService.bookAppointment(appointment);

        return "redirect:/appointments/view";
    }

    @GetMapping("/appointments")
    public String viewAppointments(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "viewAppointments";
    }

    @PostMapping("/appointments/{id}/cancel")
    public String cancel(@PathVariable Long id) {
        appointmentService.cancelAppointment(id);
        return "redirect:/appointments";
       

    }
    
    
    
}
