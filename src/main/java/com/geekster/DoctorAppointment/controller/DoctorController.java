package com.geekster.DoctorAppointment.controller;

import com.geekster.DoctorAppointment.model.Doctor;
import com.geekster.DoctorAppointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping()
    public void addDoctor(@RequestBody Doctor doctor){
        doctorService.insert(doctor);
    }
}
