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
import com.deloitte.forecastsystem.model.LoadForecastEntsoe;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastRecord;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastSumRecord;

/**
 *
 * @author Vladimir
 */
public interface LoadForecastEntsoeService {
    
    public List<LoadForecastEntsoe> findAll();
    public Optional<LoadForecastEntsoe> findById(Long id);
    public <S extends LoadForecastEntsoe> S save(S s);
    public void delete(LoadForecastEntsoe t);    
       
    public Integer findByParam(Date p_dateOfForecast, Country p_country, Date p_loadDate, Integer p_loadHour, Integer p_loadMinute); 
    public List<LoadForecastEntsoe> findByDateForecast(Date p_dateOfForecast); 
    public List<LoadForecastEntsoe> findByDateForecastCountry(Date p_dateOfForecast, Country p_country); 
    public List<LoadForecastEntsoe> findByDateForecastCountryLoadDate(Date p_dateOfForecast, Country p_country, Date p_loadDate); 
//    public Integer findByDateForecastCountryHourAvg(Date p_dateOfForecast, Country p_country, Date p_loadDate, Integer p_loadHour); 
    
    public LoadEntsoeForecastRecord findByDateForecastRecord(Date p_dateOfForecast, Country p_country, Date p_loadDate);     
    public LoadEntsoeForecastSumRecord findByDateForecastSumRecord(Date p_dateOfForecast, Country p_country, Date p_loadDate);     
    
}
