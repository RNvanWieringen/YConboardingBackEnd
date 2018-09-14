package com.onboarding.onboarding.persistence;


import com.onboarding.onboarding.model.YCProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class YCProgramService {

    @Autowired
    private YCProgramRepository ycProgramRepository;

    public YCProgram save(YCProgram ycProgram){
        return ycProgramRepository.save(ycProgram);


    }
    public YCProgram findById(Long id){
        return  ycProgramRepository.findById(id).get();
    }

    public Iterable<YCProgram> findAll(){
        Iterable<YCProgram> result = ycProgramRepository.findAll();
        return result;
    }




}
