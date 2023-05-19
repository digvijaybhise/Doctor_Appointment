package com.geekster.DoctorAppointment.model;

import jakarta.persistence.*;

import java.util.List;

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;
    private String doctorName;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
