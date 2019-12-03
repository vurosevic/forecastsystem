/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deloitte.forecastsystem_bih.model.WeatherForecast;
import deloitte.forecastsystem_bih.model.WeatherForecastDaily;
import deloitte.forecastsystem_bih.repository.WeatherForecastDailyRepository;
import deloitte.forecastsystem_bih.service.WeatherForecastDailyService;

/**
 *
 * @author Vladimir
 */
@Service("weatherForecastDailyService")
@Transactional
public class WeatherForecastDailyServiceImpl implements WeatherForecastDailyService {

    @Autowired
    WeatherForecastDailyRepository weatherForecastDailyDAO;
    
    @Override
    public List<WeatherForecastDaily> findAll() {
        return weatherForecastDailyDAO.findAll();
    }

    @Override
    public Optional<WeatherForecastDaily> findById(Long id) {
        return weatherForecastDailyDAO.findById(id);
    }

    @Override
    public <S extends WeatherForecastDaily> S save(S s) {
        return weatherForecastDailyDAO.save(s);
    }

    @Override
    public void delete(WeatherForecastDaily t) {
        weatherForecastDailyDAO.delete(t);
    }

    @Override
    public List<WeatherForecastDaily> findByDate(WeatherForecast p_weatherForecast) {
        return weatherForecastDailyDAO.findByDate(p_weatherForecast);
    }
    
}
