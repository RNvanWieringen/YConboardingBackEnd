package com.onboarding.onboarding.persistence;


import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.YCProgram;
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

    public Iterable<Employee> findByProgram(YCProgram program) {
        Iterable<Employee> result = employeeRepository.findEmployeeByProgram(program);
        return result;
    }

}
