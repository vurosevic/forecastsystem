/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.WeatherForecast;

/**
 *
 * @author Vladimir
 */
@Repository("weatherForecastDAO")
public interface WeatherForecastRepository extends CrudRepository<WeatherForecast, Long>{

    @Override
    public List<WeatherForecast> findAll();

    @Override
    public Optional<WeatherForecast> findById(Long id);

    @Override
    public <S extends WeatherForecast> S save(S s);

    @Override
    public void delete(WeatherForecast t);     
    
    @Query("SELECT wf FROM WeatherForecast wf WHERE country=:p_country AND forecastTime=:p_forecastTime")
    public List<WeatherForecast> findByDate(@Param("p_country") Country p_country, @Param("p_forecastTime") Date p_forecastTime);    
    
}
