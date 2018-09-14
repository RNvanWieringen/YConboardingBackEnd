package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends CrudRepository <Employee, Long> {
}
