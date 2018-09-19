package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.Fillout;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
public interface FilloutRepository extends CrudRepository <Fillout, Long> {
    @Query("SELECT f FROM Fillout f where f.employee = :employee")
    public Fillout findFilloutByEmployee(@Param("employee") Employee employee);

    @Transactional
    @Modifying
    @Query("DELETE FROM Fillout f where f.employee = :employee")
    public void deleteByEmployee(@Param("employee") Employee employee);
}
