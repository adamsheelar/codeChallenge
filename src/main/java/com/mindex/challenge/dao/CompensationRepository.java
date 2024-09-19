package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    //has to be diffrent than employee repository, inorder for db to querry propperly
    Compensation findByEmployee(Employee employee);
}
