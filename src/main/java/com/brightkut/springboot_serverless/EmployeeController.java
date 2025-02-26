package com.brightkut.springboot_serverless;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id) {
        return new ResponseEntity<>(employeeRepo.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeRepo.update(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return new ResponseEntity<>(employeeRepo.delete(id), HttpStatus.OK);
    }
}
