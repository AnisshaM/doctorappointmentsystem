package com.example.doctorappointmentsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctorappointmentsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
