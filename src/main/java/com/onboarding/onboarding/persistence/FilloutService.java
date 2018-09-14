package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Fillout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FilloutService {

    @Autowired
    private FilloutRepository filloutRepository;

    public Fillout save(Fillout fillout){
        return filloutRepository.save(fillout);
    }

    public Fillout findById(Long id){
        return filloutRepository.findById(id).get();
    }

    public Iterable <Fillout> findAll(){
        Iterable <Fillout> result = filloutRepository.findAll();
        return result;
    }
}
