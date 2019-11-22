/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.WeatherForecast;
import deloitte.forecastsystem_bih.model.WeatherForecastHourly;
import deloitte.forecastsystem_bih.model.communication.WeatherForecastRecord;

/**
 *
 * @author Vladimir
 */
public interface WeatherForecastHourlyRepository extends CrudRepository<WeatherForecastHourly, Long>{

    @Override
    public List<WeatherForecastHourly> findAll();

    @Override
    public Optional<WeatherForecastHourly> findById(Long id);

    @Override
    public <S extends WeatherForecastHourly> S save(S s);

    @Override
    public void delete(WeatherForecastHourly t);
    
    @Query("SELECT wfh FROM WeatherForecastHourly wfh WHERE weatherForecast=:p_weatherForecast")
    public List<WeatherForecastHourly> findByDate(@Param("p_weatherForecast") WeatherForecast p_weatherForecast);    
        
    @Query("SELECT wfh FROM WeatherForecastHourly wfh WHERE weatherForecast=:p_weatherForecast AND dayForecast=:p_Day_forecast")
    public List<WeatherForecastHourly> findByDayForecats(@Param("p_weatherForecast") WeatherForecast p_weatherForecast, @Param("p_Day_forecast") Date p_Day_forecast);    
    
    @Query("SELECT new deloitte.forecastsystem_bih.model.communication.WeatherForecastRecord(AVG(wfh.temperature), MIN(wfh.temperature), MAX(wfh.temperature), AVG(wfh.apparentTemperature), MIN(wfh.apparentTemperature), MAX(wfh.apparentTemperature)) FROM WeatherForecastHourly wfh WHERE weatherForecast=:p_weatherForecast AND dayForecast=:p_Day_forecast")
    public WeatherForecastRecord findByDayForecatsRecord(@Param("p_weatherForecast") WeatherForecast p_weatherForecast, @Param("p_Day_forecast") @Temporal(TemporalType.DATE) Date p_Day_forecast);       
    
    @Query("SELECT MIN(wfh.hourForecast) FROM WeatherForecastHourly wfh WHERE weatherForecast=:p_weatherForecast AND dayForecast=:p_Day_forecast")
    public Integer findByDayForecatsByHourStart(@Param("p_weatherForecast") WeatherForecast p_weatherForecast, @Param("p_Day_forecast") Date p_Day_forecast);        
    
    @Query("SELECT wfh FROM WeatherForecastHourly wfh WHERE weatherForecast=:p_weatherForecast AND dayForecast=:p_Day_forecast AND hourForecast=:p_hourForecast")
    public List<WeatherForecastHourly> findByDayForecatsByHour(@Param("p_weatherForecast") WeatherForecast p_weatherForecast, @Param("p_Day_forecast") Date p_Day_forecast, @Param("p_hourForecast") Integer p_hourForecast);    
    
}
