package com.mindex.challenge.service.impl;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import java.util.*;





@Service
public class ReportingStructureServiceImpl implements ReportingStructureService{
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
    @Autowired private EmployeeService employeeService;

    @Override public ReportingStructure create(String id){
        LOG.debug("Creating ReportingStructure for id [{}]",id);
        ReportingStructure report = new ReportingStructure();
        Employee e = employeeService.read(id);
        report.setEmployee(e);
        report.setNumberOfReports(calculateNumReports(e));
        return report;
    }


    private int calculateNumReports(Employee employee){
        List<Employee> reports = employee.getDirectReports();

        if( reports== null || reports.isEmpty()){
            //base case (at a leaf node in the hierarchy)
            return 0 ;
        }
        //recursive approch ~ roughly inorder traversal of reporting heirarchy 
        int totalR = 0;
        for(Employee e : reports){
            //full deatails of the employee
            Employee emp = employeeService.read(e.getEmployeeId());
            totalR += 1 + calculateNumReports(emp);
        }
        return totalR;
    }
}
