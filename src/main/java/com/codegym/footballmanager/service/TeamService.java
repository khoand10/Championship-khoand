package com.codegym.footballmanager.service;

import com.codegym.footballmanager.model.Team;

public interface TeamService {

    Iterable<Team> findAll();

    Team findById(int id);

    Team save(Team team);

    void delete(int id);

}
