package com.geekster.DoctorAppointment.repository;

import com.geekster.DoctorAppointment.model.Appointment;
import com.geekster.DoctorAppointment.model.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, AppointmentKey> {
}
