/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deloitte.forecastsystem.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.Weather;
import com.deloitte.forecastsystem.model.WeatherForecast;
import com.deloitte.forecastsystem.model.WeatherForecastHourly;

/**
 *
 * @author Vladimir
 */
@Repository("weatherDAO")
public interface WeatherRepository extends CrudRepository<Weather, Long>{

    @Override
    public List<Weather> findAll();

    @Override
    public Optional<Weather> findById(Long id);

    @Override
    public void delete(Weather t);

    @Override
    public <S extends Weather> S save(S s);
   
    @Query("SELECT wf FROM WeatherForecast wf WHERE forecastTime=:p_forecastTime AND country=:p_country")
    public WeatherForecast findByDate(@Param("p_forecastTime") Date p_forecastTime, @Param("p_country") Country p_country);    
    
}
