package com.onboarding.onboarding.persistence;


import com.onboarding.onboarding.model.Form;
import com.onboarding.onboarding.model.YCProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Iterable<Form> findByProgram(YCProgram program) {
        return formRepository.findByProgram(program);
    }

    public Iterable<Form> findAll(){
        Iterable <Form> result = formRepository.findAll();
        return result;
    }


}
