package com.mindex.challenge.data;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(){

    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    public Employee getEmployee(){
        return this.employee;
    }

    public void setNumberOfReports(int num){
        this.numberOfReports = num;

    }
    public int getNumberOfReports(){
        return this.numberOfReports;
    
    }

}
