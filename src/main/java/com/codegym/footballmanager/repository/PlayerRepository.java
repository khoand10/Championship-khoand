package com.codegym.footballmanager.repository;

import com.codegym.footballmanager.model.Player;
import com.codegym.footballmanager.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Integer> {

//    @Query("select new Player (p.id, p.title, p.teaser, p.feature, p.created, p.likes, p.category) from Post p where p.category = :category")
//    Team<Player> findByCategory(@Param("team") Team team);
}
