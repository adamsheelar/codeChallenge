package com.mindex.challenge.data;
import java.time.*;

import com.fasterxml.jackson.annotation.JsonFormat;
public class Compensation {
    private Employee employee;
    private String salary;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    //ex "2024-09-18T12:00:00"
    private LocalDateTime effectiveDate;



    public Compensation (){

    }

    public void setEmployee(Employee employee){
        this.employee = employee;
 
    }
    public Employee getEmployee(){
        return this.employee;
    }

    public String getSalary(){
        return this.salary;
    }

    public void setSalary(String salary){
        this.salary = salary;
    }

    public LocalDateTime getEffectiveDate(){
        return this.effectiveDate;
    }
    public void setEffectiveDate(LocalDateTime date){
        this.effectiveDate = date;
    }



}
