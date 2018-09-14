package com.onboarding.onboarding.persistence;

import com.onboarding.onboarding.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team save(Team team){
        return teamRepository.save(team);
    }

    public Team findById(Long id) {
        return teamRepository.findById(id).get();
    }

    public Iterable <Team> findAll(){
        Iterable <Team> result = teamRepository.findAll();
        return result;
    }
}