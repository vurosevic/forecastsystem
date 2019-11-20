/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.WeatherForecast;

/**
 *
 * @author Vladimir
 */
public interface WeatherForecastService {
 
    public List<WeatherForecast> findAll();
    public Optional<WeatherForecast> findById(Long id);
    public <S extends WeatherForecast> S save(S s);
    public void delete(WeatherForecast t);      
    public List<WeatherForecast> findByDate(Country p_country, Date p_forecastTime);    
}
