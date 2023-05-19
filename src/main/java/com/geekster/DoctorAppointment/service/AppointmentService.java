package com.geekster.DoctorAppointment.service;

import com.geekster.DoctorAppointment.model.Appointment;
import com.geekster.DoctorAppointment.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepository appointmentRepository;

    public void bookAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
