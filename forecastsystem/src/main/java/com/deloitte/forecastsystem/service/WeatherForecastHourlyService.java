/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deloitte.forecastsystem.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deloitte.forecastsystem.model.WeatherForecast;
import com.deloitte.forecastsystem.model.WeatherForecastHourly;
import com.deloitte.forecastsystem.model.communication.WeatherForecastRecord;

/**
 *
 * @author Vladimir
 */
public interface WeatherForecastHourlyService {

    public List<WeatherForecastHourly> findAll();    
    public Optional<WeatherForecastHourly> findById(Long id);
    public <S extends WeatherForecastHourly> S save(S s);
    public void delete(WeatherForecastHourly t);
    public List<WeatherForecastHourly> findByDate(WeatherForecast p_weatherForecast);     
    public List<WeatherForecastHourly> findByDayForecats(WeatherForecast p_weatherForecast, Date p_Day_forecast);    
    public WeatherForecastRecord findByDayForecatsRecord(WeatherForecast p_weatherForecast, Date p_Day_forecast);       
    
}
