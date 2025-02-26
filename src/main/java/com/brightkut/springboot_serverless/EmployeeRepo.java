package com.brightkut.springboot_serverless;

import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

@Repository
public class EmployeeRepo {
    private final DynamoDBMapper dynamoDBMapper;

    public EmployeeRepo(DynamoDBMapper dynamoDBMapper){
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Employee save(Employee employee){
        dynamoDBMapper.save(employee);

        return employee;
    }

    public Employee getById(String employeeId) {
        return dynamoDBMapper.load(Employee.class, employeeId);
    }

    public String update(String employeeId, Employee employee){
        dynamoDBMapper.save(employee, 
            new DynamoDBSaveExpression()
                .withExpectedEntry("employeeId", 
                    new ExpectedAttributeValue(
                        new AttributeValue()
                            .withS(employeeId)
                    )
            )
         );

        return employeeId;
    }

    public String delete(String employeeId){
        Employee employee = dynamoDBMapper.load(Employee.class, employeeId);
        dynamoDBMapper.delete(employee);

        return "Employeed id : " + employeeId + " was deleted";
    }
}