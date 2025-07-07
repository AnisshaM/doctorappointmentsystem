package com.example.doctorappointmentsystem.controller;

import com.example.doctorappointmentsystem.dao.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {

    @Autowired
    private DoctorRepository repo;

    @GetMapping("/doctors")
    public String listDoctors(Model model) {
        model.addAttribute("doctors", repo.findAll());
        return "doctorList"; // Make sure you have doctorList.html in templates
    }
}
