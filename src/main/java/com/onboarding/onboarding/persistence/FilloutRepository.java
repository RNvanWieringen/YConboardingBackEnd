package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.Fillout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


@Component
public interface FilloutRepository extends CrudRepository <Fillout, Long> {
    @Query("SELECT f FROM Fillout f where f.employee = :employee")
    public String findFilloutByEmployee(@Param("employee") Employee employee);
}
