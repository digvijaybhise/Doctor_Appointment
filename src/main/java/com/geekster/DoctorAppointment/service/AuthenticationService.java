package com.geekster.DoctorAppointment.service;

import com.geekster.DoctorAppointment.model.AuthenticationToken;
import com.geekster.DoctorAppointment.repository.IAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepository authenticationRepository;

    public boolean authenticate(String patientEmail, String token) {
        AuthenticationToken token1 = authenticationRepository.findByToken(token);
        String expectedEmail = token1.getPatient().getPatientEmail();
        return  expectedEmail.equals(patientEmail);
    }

    public void save(AuthenticationToken token) {
        authenticationRepository.save(token);
    }
}
