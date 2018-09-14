package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Fillout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface FilloutRepository extends CrudRepository<Fillout, Long> {
}
