package com.coaching.centre;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity 
public class Student {
    @Id 
   private int id;
    private String name;
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
