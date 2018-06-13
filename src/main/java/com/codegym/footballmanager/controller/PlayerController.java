package com.codegym.footballmanager.controller;

import com.codegym.footballmanager.model.Player;
import com.codegym.footballmanager.model.Team;
import com.codegym.footballmanager.service.PlayerService;
import com.codegym.footballmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    TeamService teamService;

    @ModelAttribute("team")
    public Iterable<Team> teams(){
        return teamService.findAll();
    }

    @GetMapping("/player/{id}/view")
    public ModelAndView findAll(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("/player/view");
        List<Player> players = playerService.findAllByTeam(teamService.findById(id));
        modelAndView.addObject("info", players);
        return modelAndView;
    }

    @GetMapping("/player/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("player", new Player());
        return modelAndView;
    }

    @PostMapping("/player/create")
    public ModelAndView saveCategory(@ModelAttribute("player") Player player ){
        playerService.save(player);
        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("player", new Player());
        modelAndView.addObject("message", "Player saved successfully");
        return modelAndView;
    }

    @GetMapping("/player/{id}/edit")
    public ModelAndView showEditionForm(@PathVariable("id") int id){
        Player player = playerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/player/edit");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

    @PostMapping("/player/edit")
    public ModelAndView updateCategory(@ModelAttribute("player") Team team ){
        teamService.save(team);
        ModelAndView modelAndView = new ModelAndView("/player/edit");
//        modelAndView.addObject("team", team);
        modelAndView.addObject("message", "Player updated successfully");
        return modelAndView;
    }

    @GetMapping("/team/{id}/delete")
    public ModelAndView showDeletionForm(@PathVariable("id") int id){
        Team team = teamService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/player/delete");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @PostMapping("/team/{id}/delete")
    public String deleteCategory(@PathVariable("id")int id){
        teamService.delete(id);
        return "redirect:/team";
    }

}
