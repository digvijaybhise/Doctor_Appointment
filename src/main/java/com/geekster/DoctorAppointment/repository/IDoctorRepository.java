package com.geekster.DoctorAppointment.repository;

import com.geekster.DoctorAppointment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
}
