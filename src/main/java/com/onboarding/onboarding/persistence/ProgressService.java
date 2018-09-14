package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Progress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public Progress save(Progress progress){
        return progressRepository.save(progress);
    }

    public Progress findById(Long id) {
        return progressRepository.findById(id).get();
    }

    public Iterable <Progress> findAll(){
        Iterable <Progress> result = progressRepository.findAll();
        return result;
    }
}