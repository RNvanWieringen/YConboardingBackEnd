package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Form;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface FormRepository extends CrudRepository<Form, Long> {
}