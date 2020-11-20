/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.covid.dao;

import com.example.covid.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author Khoa
 */

@Repository("postgres")
public class CovidDatabaseService implements CovidDatabase{
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public CovidDatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertState(State state) {
        String sql = "INSERT INTO STATES (name, total_cases) VALUES(?, ?) ON CONFLICT DO NOTHING";

        jdbcTemplate.update(sql, state.getState(), state.getPositive());
    }

    @Override
    public void updateState(String name, int totalCases) {
        String sql = "UPDATE STATES SET total_cases = ? WHERE name = ?";
        jdbcTemplate.update(sql, totalCases, name);
    }

    @Override
    public State selectState(String name) {
        String sql = "SELECT name, total_cases FROM STATES WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, 
                        new Object[]{name},
                        new int[]{java.sql.Types.VARCHAR},
                        (resultSet, i) -> {
                            int stateTotalCases = resultSet.getInt("total_cases");
                            return new State(name, stateTotalCases);
                        }
                );
    }

    @Override
    public List<State> selectAllStates() {
        
        String sql = "SELECT name, total_cases FROM STATES";
        
        return jdbcTemplate.query(sql,
                            (resultSet, i) -> {
                                String stateName = resultSet.getString("name");
                                int stateTotalCases = resultSet.getInt("total_cases");
                                return new State(stateName, stateTotalCases);
                        }
                );
    }
    

  
}
