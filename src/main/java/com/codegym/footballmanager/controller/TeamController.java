package com.codegym.footballmanager.controller;

import com.codegym.footballmanager.model.Team;
import com.codegym.footballmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("teams", teamService.findAll());
        return modelAndView;
    }

    @GetMapping("/team/list")
    public ModelAndView teamList(){
        ModelAndView modelAndView = new ModelAndView("/team/list");
        modelAndView.addObject("teams", teamService.findAll());
        return modelAndView;
    }

    @GetMapping("/team/create")
    public ModelAndView showCreationForm(){
        ModelAndView modelAndView = new ModelAndView("/team/create");
        modelAndView.addObject("team", new Team());
        return modelAndView;
    }

    @PostMapping("/team/create")
    public ModelAndView saveCategory(@ModelAttribute("team") Team team ){
        teamService.save(team);
        ModelAndView modelAndView = new ModelAndView("/team/create");
        modelAndView.addObject("category", new Team());
        modelAndView.addObject("message", "Category saved successfully");
        return modelAndView;
    }

    @GetMapping("/team/{id}/edit")
    public ModelAndView showEditionForm(@PathVariable("id") int id){
        Team team = teamService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/team/edit");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @PostMapping("/team/edit")
    public ModelAndView updateCategory(@ModelAttribute("team") Team team ){
        teamService.save(team);
        ModelAndView modelAndView = new ModelAndView("/team/edit");
//        modelAndView.addObject("team", team);
        modelAndView.addObject("message", "Team updated successfully");
        return modelAndView;
    }

    @GetMapping("/team/{id}/delete")
    public ModelAndView showDeletionForm(@PathVariable("id") int id){
        Team team = teamService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/team/delete");
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @PostMapping("/team/{id}/delete")
    public String deleteCategory(@PathVariable("id")int id){
        teamService.delete(id);
        return "redirect:/team/list";
    }

}
