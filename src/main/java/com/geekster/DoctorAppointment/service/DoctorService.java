package com.geekster.DoctorAppointment.service;

import com.geekster.DoctorAppointment.model.Doctor;
import com.geekster.DoctorAppointment.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    IDoctorRepository doctorRepository;

    public void insert(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }
}
