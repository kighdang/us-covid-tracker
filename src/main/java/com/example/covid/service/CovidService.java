/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.covid.service;

import com.example.covid.dao.CovidDatabase;
import com.example.covid.model.State;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Khoa
 */

@Service
public class CovidService {
    private CovidDatabase database;  
    
    @Autowired 
    private RestTemplate restTemplate;
    
   
    private String url = "https://api.covidtracking.com/v1/states/current.json"; 
    
    @Autowired 
    public CovidService(@Qualifier("postgres") CovidDatabase db) {
        this.database = db;
    }
    
    public void insertState(State state){
        this.database.insertState(state);
    }
   
    public void updateState(String name, int newTotalCases){
        this.database.updateState(name, newTotalCases);
    }
    
    public State selectState(String name){
        return this.database.selectState(name);
    }
    
    public List<State> selectAllStates(){
        return this.database.selectAllStates();
    }
    
    public List<State> getStatesData() {
        State[] data = restTemplate.getForObject(url, State[].class);
        return Arrays.asList(data);
    
    }
    
    public void updateDatabase() {
        List<State> states = getStatesData();
        
        for (State state: states){
            insertState(state);
            updateState(state.getState(), state.getPositive());
        }
        
    }
    
    
        
    
    
   

}
