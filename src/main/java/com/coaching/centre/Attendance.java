package com.coaching.centre;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;


@Entity 
public class Attendance {
    @Id @Positive (message = "Id must be a positive number")
    private int id;
    @Positive (message=" Enrolment ID must be a positive number")
    private int enrolmentId;
    @NotNull (message="Date is required")
    @PastOrPresent (message="Date cannot be in the future")
    private LocalDate date;
    @NotNull (message = "Attendance status is required")
    private Boolean present;   
    public Attendance(){

    }
    public Attendance(int id, int enrolmentId, LocalDate date, Boolean present){
        this.id=id;
        this.enrolmentId=enrolmentId;
        this.date=date;
        this.present=present;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getEnrolmentId(){
        return enrolmentId;
    }
    public void setEnrolmentId(int enrolmentId){
        this.enrolmentId=enrolmentId;
        
    }
    public LocalDate getDate(){
        return date;
    }
    public void setDate( LocalDate date){
        this.date=date;
    }
    public Boolean getPresent(){
        return present;
    }
    public void setPresent(Boolean present){
        this.present=present;
    }
}
