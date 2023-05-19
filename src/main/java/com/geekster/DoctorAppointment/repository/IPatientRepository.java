package com.geekster.DoctorAppointment.repository;

import com.geekster.DoctorAppointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {


    Boolean existsByPatientEmail(String userEmail);

    Patient findByPatientEmail(String patientEmail);

}
