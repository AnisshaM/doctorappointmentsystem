# 🏥 Online Doctor Appointment System

A Java Spring Boot web application that allows users to book appointments with doctors based on their specialization. It demonstrates clean architecture using models, controllers, services, repositories, and Thymeleaf templates.

---

## 🚀 Features

- 👤 User and Doctor entity management
- 🗓️ Book appointments with a doctor
- 📚 View appointment details
- 🔍 Select doctor by specialization
- 🧠 MVC design with Spring Boot and Hibernate
- 🌐 HTML pages using Thymeleaf
- 💾 Data persistence with MySQL

---

## 🛠️ Technologies Used

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **Thymeleaf**
- **HTML + CSS**
- **Maven**

---

## 📁 Project Structure

doctor-appointment-system/
├── controller/
│ ├── AppointmentController.java
│ ├── AuthController.java
│ └── DoctorController.java
├── model/
│ ├── User.java
│ ├── Doctor.java
│ ├── Appointment.java
│ └── Specialization.java
├── repository/
│ ├── UserRepository.java
│ ├── DoctorRepository.java
│ ├── AppointmentRepository.java
│ └── SpecializationRepository.java
├── service/
│ └── AppointmentService.java
└── resources/
├── templates/
│ ├── appointmentForm.html
│ └── viewAppointments.html
└── application.properties
