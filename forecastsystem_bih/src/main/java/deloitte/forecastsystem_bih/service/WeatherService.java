/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.Weather;
import deloitte.forecastsystem_bih.model.WeatherForecast;

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
    public Date lastDate(Country p_country);    
    
}
