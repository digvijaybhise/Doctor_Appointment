package com.geekster.DoctorAppointment.repository;

import com.geekster.DoctorAppointment.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepository extends JpaRepository<AuthenticationToken, Integer> {


    boolean existsByPatientId(Integer patientId);

    AuthenticationToken findByToken(String token);
}
