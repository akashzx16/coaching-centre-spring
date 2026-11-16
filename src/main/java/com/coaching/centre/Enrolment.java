package com.coaching.centre;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;

@Entity 
public class Enrolment {
    @Id @Positive 
    private int id;
    @Positive (message = "Student ID must be positive")
    private int studentId;
    @Positive 
    private int batchId;
  public  Enrolment(){

    }
  public  Enrolment(int id,int studentId, int batchId){
        this.id=id;
        this.studentId=studentId;
        this.batchId=batchId;

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
    public void setStudentId(int studentId){
        this.studentId=studentId;

    }
    public  void setBatchId(int batchId){
        this.batchId=batchId;
    }

}
