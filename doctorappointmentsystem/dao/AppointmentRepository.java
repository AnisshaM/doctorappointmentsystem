package com.example.doctorappointmentsystem.dao;

import com.example.doctorappointmentsystem.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
}