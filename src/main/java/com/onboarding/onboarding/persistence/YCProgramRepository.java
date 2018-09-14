package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.YCProgram;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface YCProgramRepository extends CrudRepository<YCProgram, Long> {
}