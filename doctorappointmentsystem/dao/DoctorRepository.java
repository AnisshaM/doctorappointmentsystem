package com.example.doctorappointmentsystem.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctorappointmentsystem.model.*;
public interface DoctorRepository extends JpaRepository<Doctor, Long> {}