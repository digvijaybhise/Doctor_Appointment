package com.geekster.DoctorAppointment.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String patientFirstName;
    private String patientLastName;
    private String patientEmail;
    private String patientPassword;
    private String patientPhoneNumber;


    public Patient(String patientFirstName, String patientLastName, String patientEmail, String patientPassword, String patientPhoneNumber) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientEmail = patientEmail;
        this.patientPassword = patientPassword;
        this.patientPhoneNumber = patientPhoneNumber;
    }

    @OneToOne(mappedBy = "patient")
    private Appointment appointment;
}
