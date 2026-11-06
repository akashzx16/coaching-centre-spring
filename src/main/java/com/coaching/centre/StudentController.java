package com.coaching.centre;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController 
public class StudentController {
     private ArrayList<Student> data= new ArrayList<>();
    public StudentController(){
   
    Student s1= new Student(1, "Akash", "A");
        Student s2= new Student(2, "Saniya", "B");
        Student s3= new Student(3, "Meghna", "C");
        data.add(s1);
        data.add(s2);
        data.add(s3);
    }

     @GetMapping ("/students")
    public List<Student> getAllStudent(){

        return data;
    }
     @GetMapping ("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        for(Student s : data){
            if(s.getId()==id) return ResponseEntity.ok(s);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping ("/students")

    public ResponseEntity<Student> addStudent (@RequestBody Student stu){
        for(Student s: data){
            if(s.getId()==stu.getId()){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }
        data.add(stu);
        return ResponseEntity.status(HttpStatus.CREATED).body(stu);
    }


}
