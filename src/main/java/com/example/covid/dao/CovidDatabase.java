/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.covid.dao;

import com.example.covid.model.State;
import java.util.List;

/**
 *
 * @author Khoa
 */
public interface CovidDatabase {
    public State selectState(String name);
    public List<State> selectAllStates();
    public void insertState(State state);
    public void updateState(String name, int totalCases);
    
}
