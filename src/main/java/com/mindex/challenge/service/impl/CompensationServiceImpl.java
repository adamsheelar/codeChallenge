package com.mindex.challenge.service.impl;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindex.challenge.service.*;

@Service
public class CompensationServiceImpl implements CompensationService{
    private static final  Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);
    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Compensation create(Compensation compensation){
        LOG.debug("Creating Compensation[{}]",compensation);
        Employee employee = employeeService.read(compensation.getEmployee().getEmployeeId());
        compensation.setEmployee(employee);
        compensationRepository.insert(compensation);
        return compensation;
    }
    @Override
    public Compensation read(String employeeId){
        LOG.debug("Read Request for compensation of employee [{}]", employeeId);

        Employee employee = employeeService.read(employeeId);
        Compensation compensation = compensationRepository.findByEmployee(employee);
        if(compensation == null){
            throw new RuntimeException("No Compensation found for employeeId "+ employeeId);
        }
        return compensation;
    }
}
