package com.codegym.footballmanager.service.impl;

import com.codegym.footballmanager.model.Team;
import com.codegym.footballmanager.repository.TeamRepository;
import com.codegym.footballmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(int id) {
        return teamRepository.findOne(id);
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void delete(int id) {
        teamRepository.delete(id);
    }
}
