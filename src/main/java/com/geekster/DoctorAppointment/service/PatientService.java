package com.geekster.DoctorAppointment.service;

import com.geekster.DoctorAppointment.dto.SignInInput;
import com.geekster.DoctorAppointment.dto.SignInOutput;
import com.geekster.DoctorAppointment.dto.SignUpInput;
import com.geekster.DoctorAppointment.model.AuthenticationToken;
import com.geekster.DoctorAppointment.model.Doctor;
import com.geekster.DoctorAppointment.model.Patient;
import com.geekster.DoctorAppointment.repository.IAuthenticationRepository;
import com.geekster.DoctorAppointment.repository.IPatientRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    IAuthenticationRepository authenticationRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    DoctorService doctorService;

    public void signUp(SignUpInput signUpDto) {

        //check if patient exists or not
        boolean checkForPatient = patientRepository.existsByPatientEmail(signUpDto.getUserEmail());

        if (checkForPatient){
            throw new IllegalStateException();
        }

        //Encryption
        String encryptPassword = null;
        try{
            encryptPassword = encryption(signUpDto.getUserPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

        //Save user as Patient
        Patient patient = new Patient(signUpDto.getUserFirstName(), signUpDto.getUserLastName(),
                signUpDto.getUserEmail(), encryptPassword, signUpDto.getUserPhoneNumber());

        patientRepository.save(patient);
    }

    private String encryption(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digest = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digest);
        return hash;
    }

    public SignInOutput signin(SignInInput signInDto) {

        Patient patient = patientRepository.findByPatientEmail(signInDto.getPatientEmail());

        if (patient == null){
            throw new IllegalStateException("User Invalid!!!! Sign up instead");
        }

        //Encrypt the password
        String encryptPassword = null;
        try{
            encryptPassword = encryption(signInDto.getPatientPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean isPasswordValid = encryptPassword.equals(patient.getPatientPassword());

        AuthenticationToken token = new AuthenticationToken(patient);

        authenticationService.save(token);

        return new SignInOutput("SignIn successful", token.getToken());
    }

    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctor();
    }
}
