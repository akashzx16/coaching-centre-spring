package com.coaching.centre;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/enrolments")
public class EnrolmentController {
    private final EnrolmentRepository enrolrepo;
    private final StudentRepository studentRepository;
    private  final BatchRepository batchRepository;
    
    public EnrolmentController(EnrolmentRepository enrolrepo,StudentRepository studentRepository, BatchRepository batchRepository){
        this.studentRepository=studentRepository;
        this.batchRepository=batchRepository;   
        this.enrolrepo=enrolrepo;

    }
    @PostMapping 
    public ResponseEntity<Enrolment> createEnrolment(@Valid @RequestBody Enrolment enrolment){
        if(enrolrepo.existsById(enrolment.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (!studentRepository.existsById(enrolment.getStudentId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(!batchRepository.existsById(enrolment.getBatchId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }



        Enrolment savedEnrolment = enrolrepo.save(enrolment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEnrolment);  
    }
    @GetMapping 
    public List<Enrolment> getAllEnrolments(){
        return enrolrepo.findAll();
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Enrolment> getEnrolment(@PathVariable int id){
        Optional<Enrolment> enrolment = enrolrepo.findById(id);
        if(enrolment.isPresent()){
            return ResponseEntity.ok(enrolment.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteEnrolment(@PathVariable int id){
        if(!enrolrepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        enrolrepo.deleteById(id);
        return ResponseEntity.noContent().build();  
    }



}
