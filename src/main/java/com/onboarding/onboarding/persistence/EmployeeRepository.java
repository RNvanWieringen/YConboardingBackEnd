package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.YCProgram;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public interface EmployeeRepository extends CrudRepository <Employee, Long> {
    @Query("SELECT e FROM Employee e where e.ycProgram = :program")
    public Iterable<Employee> findEmployeeByProgram(@Param("program") YCProgram program);
}
