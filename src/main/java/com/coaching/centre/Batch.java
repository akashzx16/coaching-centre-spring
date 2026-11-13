package com.coaching.centre;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity 
public class Batch {
    @Id @Positive 
    private int id;
    @NotBlank (message = "Name is required")
    private String name;
    private  String grade;
    @NotBlank (message = "Subject is required")
    private String subject;
    private String schedule;
    public Batch(){

    }
    public Batch(int id, String name,String grade, String subject,String schedule){
        this.id=id;
        this.name=name;
        this.grade=grade;
        this.subject=subject;
        this.schedule=schedule;

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
    public String getSubject(){
        return subject;
    }
    public String getSchedule(){
        return schedule;
    } 
    public void setName(String name){
        this.name=name;

    }
    public void setGrade(String grade){
        this.grade=grade;
    }
    public void setSubject(String subject){
        this.subject=subject;
    }
    public void setSchedule(String schedule){
        this.schedule=schedule;
    }
    
}
