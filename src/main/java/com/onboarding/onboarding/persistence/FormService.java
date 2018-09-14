package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FormService {
    @Autowired
    private FormRepository formRepository;

    public Form save(Form form){
        return formRepository.save(form);
    }

    public Form findById(Long id){
        return formRepository.findById(id).get();
    }
    public Iterable<Form> findAll(){
        Iterable <Form> result = formRepository.findAll();
        return result;
    }


}