package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public Manager save(Manager manager){
        return managerRepository.save(manager);
    }

    public Manager findById(Long id){
        return managerRepository.findById(id).get();
    }

    public Iterable <Manager> findAll(){
        Iterable <Manager> result = managerRepository.findAll();
        return result;
    }
    
}