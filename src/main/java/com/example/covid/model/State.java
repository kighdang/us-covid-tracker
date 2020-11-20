/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.covid.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Khoa
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class State {
    String state;
    int positive;
    public State(){}
    
    public State(String state, int positive) {
        this.state = state;
        this.positive = positive;
    }

    public String getState() {
        return state;
    }

    public int getPositive() {
        return positive;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("positive")
    public void setPositiveTestsViral(int positive) {
        this.positive = positive;
    }
    
    
    
}
