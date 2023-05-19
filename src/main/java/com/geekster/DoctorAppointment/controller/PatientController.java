package com.geekster.DoctorAppointment.controller;

import com.geekster.DoctorAppointment.dto.SignInInput;
import com.geekster.DoctorAppointment.dto.SignInOutput;
import com.geekster.DoctorAppointment.dto.SignUpInput;
import com.geekster.DoctorAppointment.model.Doctor;
import com.geekster.DoctorAppointment.service.AuthenticationService;
import com.geekster.DoctorAppointment.service.PatientService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody SignUpInput signUpDto){

        String response;
        HttpStatus status;

        try{
            patientService.signUp(signUpDto);
            response = "Patient registered successfully";
            status = HttpStatus.CREATED;
        }catch (Exception e){
            response = "Patient already existed..... Sign in Instead";
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }

    @PostMapping("signin")
    public SignInOutput signin(@RequestBody SignInInput signInDto){
        return patientService.signin(signInDto);
    }

    @GetMapping("doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam String patientEmail, @RequestParam String token){

        List<Doctor> allDoctors = null;
        HttpStatus status;

        if(authenticationService.authenticate(patientEmail,token)) {
            allDoctors =  patientService.getAllDoctors();
            status = HttpStatus.OK;
        }else{
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<>(allDoctors, status);
    }
}
