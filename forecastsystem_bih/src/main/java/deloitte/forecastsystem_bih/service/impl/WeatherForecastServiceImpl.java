/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.WeatherForecast;
import deloitte.forecastsystem_bih.repository.WeatherForecastRepository;
import deloitte.forecastsystem_bih.service.WeatherForecastService;

/**
 *
 * @author Vladimir
 */
@Service("weatherForecastService")
@Transactional
public class WeatherForecastServiceImpl implements WeatherForecastService {

    @Autowired
    WeatherForecastRepository weatherForecastDAO;
    
    @Override
    public List<WeatherForecast> findAll() {
        return weatherForecastDAO.findAll();
    }

    @Override
    public Optional<WeatherForecast> findById(Long id) {
        return weatherForecastDAO.findById(id);
    }

    @Override
    public <S extends WeatherForecast> S save(S s) {
        return weatherForecastDAO.save(s);
    }

    @Override
    public void delete(WeatherForecast t) {
        weatherForecastDAO.delete(t);
    }

    @Override
    public List<WeatherForecast> findByDate(Country p_country, Date p_forecastTime) {
        return weatherForecastDAO.findByDate(p_country, p_forecastTime);
    }
    
}
