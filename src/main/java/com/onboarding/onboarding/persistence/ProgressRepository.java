package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Progress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProgressRepository extends CrudRepository<Progress, Long> {

}