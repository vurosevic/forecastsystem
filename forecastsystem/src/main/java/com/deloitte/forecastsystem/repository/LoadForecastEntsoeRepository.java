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

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.LoadForecastEntsoe;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastRecord;

/**
 *
 * @author Vladimir
 */
public interface LoadForecastEntsoeRepository extends CrudRepository<LoadForecastEntsoe, Long>{

    @Override
    public List<LoadForecastEntsoe> findAll();

    @Override
    public Optional<LoadForecastEntsoe> findById(Long id);

    @Override
    public <S extends LoadForecastEntsoe> S save(S s);

    @Override
    public void delete(LoadForecastEntsoe t);
        
    @Query("SELECT lfe.loadForecastEntsoe FROM LoadForecastEntsoe lfe WHERE dateOfForecast=:p_dateOfForecast AND country=:p_country AND loadDate=:p_loadDate AND loadHour=:p_loadHour AND loadMinute=:p_loadMinute")
    public Integer findByParam(@Param("p_dateOfForecast") Date p_dateOfForecast,
                               @Param("p_country") Country p_country, @Param("p_loadDate") Date p_loadDate, 
                               @Param("p_loadHour") Integer p_loadHour, @Param("p_loadMinute") Integer p_loadMinute); 

    @Query("SELECT lfe.loadForecastEntsoe FROM LoadForecastEntsoe lfe WHERE dateOfForecast=:p_dateOfForecast")
    public List<LoadForecastEntsoe> findByDateForecast(@Param("p_dateOfForecast") Date p_dateOfForecast); 

    @Query("SELECT lfe.loadForecastEntsoe FROM LoadForecastEntsoe lfe WHERE dateOfForecast=:p_dateOfForecast AND country=:p_country")
    public List<LoadForecastEntsoe> findByDateForecastCountry(@Param("p_dateOfForecast") Date p_dateOfForecast,
                                                              @Param("p_country") Country p_country); 

    @Query("SELECT lfe.loadForecastEntsoe FROM LoadForecastEntsoe lfe WHERE dateOfForecast=:p_dateOfForecast AND country=:p_country AND loadDate=:p_loadDate")
    public List<LoadForecastEntsoe> findByDateForecastCountryLoadDate(@Param("p_dateOfForecast") Date p_dateOfForecast,
                                                                      @Param("p_country") Country p_country, @Param("p_loadDate") Date p_loadDate);     

    @Query("SELECT AVG(lfe.loadForecastEntsoe), MIN(lfe.loadForecastEntsoe), MAX(lfe.loadForecastEntsoe) FROM LoadForecastEntsoe lfe WHERE dateOfForecast=:p_dateOfForecast AND country=:p_country AND loadDate=:p_loadDate")
    public Object[] findByDateForecastRecord(@Param("p_dateOfForecast") Date p_dateOfForecast,
                                                    @Param("p_country") Country p_country, @Param("p_loadDate") Date p_loadDate);     
         
}
