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
    @GetMapping ("/students")
    public List<Student> getAllStudent(){
        ArrayList<Student> data=new ArrayList<>();
        Student s1= new Student(1, "Akash", "A");
        Student s2= new Student(2, "Saniya", "B");
        Student s3= new Student(3, "Meghna", "C");
        data.add(s1);
        data.add(s2);
        data.add(s3);
        return data;
    }
    @GetMapping ("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
         ArrayList<Student> data=new ArrayList<>();
        Student s1= new Student(1, "Akash", "A");
        Student s2= new Student(2, "Saniya", "B");
        Student s3= new Student(3, "Meghna", "C");
        data.add(s1);
        data.add(s2);
        data.add(s3);
        for(Student s : data){
            if(s.getId()==id) return ResponseEntity.ok(s);
        }
        return ResponseEntity.notFound().build();
    }
}
