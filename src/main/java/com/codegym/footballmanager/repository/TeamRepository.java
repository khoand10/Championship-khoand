package com.codegym.footballmanager.repository;

import com.codegym.footballmanager.model.Player;
import com.codegym.footballmanager.model.Team;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TeamRepository extends PagingAndSortingRepository<Team, Integer> {
}
