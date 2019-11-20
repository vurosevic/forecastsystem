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

import deloitte.forecastsystem_bih.model.WeatherForecast;
import deloitte.forecastsystem_bih.model.WeatherForecastDaily;

/**
 *
 * @author Vladimir
 */
public interface WeatherForecastDailyRepository extends CrudRepository<WeatherForecastDaily, Long>{

    @Override
    public List<WeatherForecastDaily> findAll();

    @Override
    public Optional<WeatherForecastDaily> findById(Long id);

    @Override
    public <S extends WeatherForecastDaily> S save(S s);

    @Override
    public void delete(WeatherForecastDaily t);
    
    @Query("SELECT wfd FROM WeatherForecastDaily wfd WHERE weatherForecast=:p_weatherForecast")
    public List<WeatherForecastDaily> findByDate(@Param("p_weatherForecast") WeatherForecast p_weatherForecast);    
        
}
