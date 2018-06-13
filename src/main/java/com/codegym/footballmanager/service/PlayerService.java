package com.codegym.footballmanager.service;

import com.codegym.footballmanager.model.Player;
import com.codegym.footballmanager.model.Team;

import java.util.List;

public interface PlayerService {

    Iterable<Player> findAll();

    Player findById(int id);

    Player save(Player team);

    void delete(int id);

    public List<Player> findAllByTeam(Team team);

}
