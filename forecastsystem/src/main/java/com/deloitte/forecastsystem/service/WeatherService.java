/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deloitte.forecastsystem.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.Weather;
import com.deloitte.forecastsystem.model.WeatherForecast;

/**
 *
 * @author Vladimir
 */
public interface WeatherService {
    
    public List<Weather> findAll();
    public Optional<Weather> findById(Long id);
    public void delete(Weather t);
    public <S extends Weather> S save(S s);  
    public WeatherForecast findByDate(Date p_forecastTime, Country p_country);    
    
}
