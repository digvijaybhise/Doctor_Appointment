package com.geekster.DoctorAppointment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    private String token;
    private LocalDateTime tokenCreationDate;

    @OneToOne
    @JoinColumn(nullable = false)
    private Patient patient;

    public AuthenticationToken(Patient patient){
        this.token = UUID.randomUUID().toString();
        this.tokenCreationDate = LocalDateTime.now();
        this.patient = patient;
    }
}
