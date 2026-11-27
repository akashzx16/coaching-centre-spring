package com.coaching.centre;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Enrolment {
    @Id @Positive 
    private int id;
    @Positive (message = "Student ID must be positive")
    private int studentId;
    @Positive 
    private int batchId;
    @NotNull (message = "JoiningDate is required")
    @PastOrPresent (message = "Joining Date can not be in the future")
    private LocalDate joiningDate;

     @PastOrPresent (message = "Leaving Date can not be in the future")
    private LocalDate leavingDate;

    

    
  public  Enrolment(){

    }
  public  Enrolment(int id,int studentId, int batchId, LocalDate joiningDate, LocalDate leavingDate){
        this.id=id;
        this.studentId=studentId;
        this.batchId=batchId;
        this.joiningDate=joiningDate;
        this.leavingDate=leavingDate;

    }
    public int getId(){
        return id;
    }
    public int getStudentId(){
        return studentId;
    }
    public int getBatchId(){
        return batchId;
    }
    public LocalDate getJoiningDate(){
        return joiningDate;
    }
    public LocalDate getLeavingDate(){
        return leavingDate;
    }
    public void setStudentId(int studentId){
        this.studentId=studentId;

    }
    public  void setBatchId(int batchId){
        this.batchId=batchId;
    }
    public void setJoiningDate(LocalDate joiningDate){
        this.joiningDate=joiningDate;
    }
    public void setLeavingDate(LocalDate leavingDate){
        this.leavingDate=leavingDate;
    }
    @JsonIgnore 
    @AssertTrue(message = "Leaving date cannot be before joining date")
    public boolean isDateRangeValid() {
            if(leavingDate==null || joiningDate== null ) return true;
            if(leavingDate.isBefore(joiningDate)) return false;
            return true;
        }

}
