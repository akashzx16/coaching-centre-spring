package com.coaching.centre;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


    @Entity 
public class Student {
    @Id @Positive(message = "ID must be positive") 
   private int id;  //primary key 
   @NotBlank (message = "Name is required")
    private String name;
    @NotBlank (message = "Grade is required")
    private String grade;
    public Student(){

    }
   public  Student(int id, String name, String grade){
        this.id=id;
        this.name=name;
        this.grade= grade;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getGrade(){
        return grade;
    }
    public void SetName(String name){
        this.name=name;

    }
    public void SetGrade(String grade){
        this.grade=grade;
    }
    
}
