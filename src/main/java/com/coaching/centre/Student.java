package com.coaching.centre;

public class Student {
   private int id;
    private String name;
    private String grade;
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
