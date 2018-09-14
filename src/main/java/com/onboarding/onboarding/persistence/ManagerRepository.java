package com.onboarding.onboarding.persistence;

import org.springframework.stereotype.Component;

@Component
public interface ManagerRepository extends CrudRepository<Manager, Long> {
}