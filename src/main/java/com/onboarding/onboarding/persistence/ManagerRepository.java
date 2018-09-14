package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ManagerRepository extends CrudRepository<Manager, Long> {
}