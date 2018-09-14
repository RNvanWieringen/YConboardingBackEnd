package com.onboarding.onboarding.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface FilloutRepository extends CrudRepository<Fillout, Long> {
}
