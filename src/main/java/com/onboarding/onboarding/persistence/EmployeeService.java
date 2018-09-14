package com.onboarding.onboarding.persistence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public Iterable <Employee> findAll(){
        Iterable <Employee> result = employeeRepository.findAll();
        return result;
    }



}
