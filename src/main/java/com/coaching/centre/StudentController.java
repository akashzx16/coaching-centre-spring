package com.coaching.centre;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import jakarta.validation.Valid;


@RestController 

public class StudentController {

    private final StudentRepository repository;
    public StudentController (StudentRepository repo){
        this.repository=repo;
    }


     

     @GetMapping ("/students")
    public List<Student> getAllStudent(){
        return repository.findAll();

    }

     @GetMapping ("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return repository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping ("/students")

    public ResponseEntity<Student> addStudent (@Valid @RequestBody Student stu){
        if (repository.existsById(stu.getId())) {
    return ResponseEntity.status(HttpStatus.CONFLICT).build();
}
      repository.save(stu);
        return ResponseEntity.status(HttpStatus.CREATED).body(stu);
    }


    @PutMapping ("/students/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @Valid @RequestBody Student newStudent){
            Optional<Student> found = repository.findById(id);
                if (found.isPresent()) {
                Student s = found.get();
                s.SetName(newStudent.getName());
                s.SetGrade(newStudent.getGrade());
                repository.save(s);
                return ResponseEntity.ok(s);
            }
            return ResponseEntity.notFound().build();    
    }


    @DeleteMapping ("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
    }


}
