/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deloitte.forecastsystem.service;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.WeatherForecast;
import com.deloitte.forecastsystem.model.WeatherForecastDaily;

/**
 *
 * @author Vladimir
 */
public interface WeatherForecastDailyService {
    
    public List<WeatherForecastDaily> findAll();
    public Optional<WeatherForecastDaily> findById(Long id);
    public <S extends WeatherForecastDaily> S save(S s);
    public void delete(WeatherForecastDaily t);
    public List<WeatherForecastDaily> findByDate(WeatherForecast p_weatherForecast);    
         
}
