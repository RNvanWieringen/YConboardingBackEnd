package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.Fillout;
import com.onboarding.onboarding.model.Form;
import com.onboarding.onboarding.model.YCProgram;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface FormRepository extends CrudRepository<Form, Long> {
    @Query("SELECT f FROM Form f where f.program = :program")
    public Iterable<Form> findByProgram(@Param("program") YCProgram program);
}
