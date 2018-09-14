package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TeamRepository extends CrudRepository<Team, Long> {

}