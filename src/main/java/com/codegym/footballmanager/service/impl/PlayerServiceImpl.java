package com.codegym.footballmanager.service.impl;

import com.codegym.footballmanager.model.Player;
import com.codegym.footballmanager.model.Team;
import com.codegym.footballmanager.repository.PlayerRepository;
import com.codegym.footballmanager.repository.TeamRepository;
import com.codegym.footballmanager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Iterable<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(int id) {
        return playerRepository.findOne(id);
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void delete(int id) {
        playerRepository.delete(id);
    }

    @Override
    public List<Player> findAllByTeam(Team team) {
        return playerRepository.findAllByTeam(team);
    }


}
