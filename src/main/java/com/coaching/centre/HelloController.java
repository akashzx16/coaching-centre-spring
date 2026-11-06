package com.coaching.centre;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
    @GetMapping ("/hello")
    public String hello(){
        String msg="Akash Here..!";
        return msg;
    }
    @GetMapping ("/student")
    public Student getStudent(){
        Student s1= new Student(1, "Akash", "A");
        return s1;
    }
   
   
}
