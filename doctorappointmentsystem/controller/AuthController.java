package com.example.doctorappointmentsystem.controller;

import com.example.doctorappointmentsystem.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @Autowired 
    private UserRepository userRepo;

    @GetMapping("/login")
    public String login() {
        return "login"; // Make sure you have login.html in templates
    }

	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
}
