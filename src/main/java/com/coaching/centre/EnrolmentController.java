package com.coaching.centre;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/enrolments")
public class EnrolmentController {
    private final EnrolmentRepository enrolrepo;
    
    public EnrolmentController(EnrolmentRepository enrolrepo){
        this.enrolrepo=enrolrepo;

    }
    @PostMapping 
    public ResponseEntity<Enrolment> createEnrolment(@Valid @RequestBody Enrolment enrolment){
        if(enrolrepo.existsById(enrolment.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Enrolment savedEnrolment = enrolrepo.save(enrolment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEnrolment);  
    }
    @GetMapping 
    public List<Enrolment> getAllEnrolments(){
        return enrolrepo.findAll();
    }
}
