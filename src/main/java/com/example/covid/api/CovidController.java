/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.covid.api;

import com.example.covid.model.State;
import com.example.covid.service.CovidService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Khoa
 */

@RequestMapping("/api/v1")
@RestController
public class CovidController {
    private final CovidService covidDataService;
    
    
    @Autowired
    public CovidController(CovidService covidDataService) {
        this.covidDataService = covidDataService;
        
    }
    
    @PostMapping
    public void insertState(@Valid @NonNull @RequestBody State state){
        this.covidDataService.insertState(state);
    }
    
    @GetMapping(path = "states/{name}")
    public State selectState(@PathVariable("name") String name){
        return this.covidDataService.selectState(name);
    }
    
    @GetMapping(path = "states")
    public List<State> getAllStates(){
        return this.covidDataService.selectAllStates();
    
    }
    
    @PutMapping(path = "states/{name}")
    public void updateState(@PathVariable("name") String name, @Valid @NonNull @RequestBody int totalCases){
        this.covidDataService.updateState(name, totalCases);
    }
    
    @GetMapping
    public void getData(){
        this.covidDataService.updateDatabase();
    }
    
    
}
