/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deloitte.forecastsystem.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.WeatherForecast;
import com.deloitte.forecastsystem.model.WeatherForecastHourly;
import com.deloitte.forecastsystem.model.communication.WeatherForecastRecord;
import com.deloitte.forecastsystem.repository.WeatherForecastHourlyRepository;
import com.deloitte.forecastsystem.service.WeatherForecastHourlyService;

/**
 *
 * @author Vladimir
 */
@Service("weatherForecastHourlyService")
public class WeatherForecastHourlyServiceImpl implements WeatherForecastHourlyService {

    @Autowired
    WeatherForecastHourlyRepository weatherForecastHourlyDAO;
    
    @Override
    public List<WeatherForecastHourly> findAll() {
        return weatherForecastHourlyDAO.findAll();
    }

    @Override
    public Optional<WeatherForecastHourly> findById(Long id) {
        return weatherForecastHourlyDAO.findById(id);
    }

    @Override
    public <S extends WeatherForecastHourly> S save(S s) {
        return weatherForecastHourlyDAO.save(s);
    }

    @Override
    public void delete(WeatherForecastHourly t) {
        weatherForecastHourlyDAO.delete(t);
    }

    @Override
    public List<WeatherForecastHourly> findByDate(WeatherForecast p_weatherForecast) {
        return weatherForecastHourlyDAO.findByDate(p_weatherForecast);
    }

	@Override
	public List<WeatherForecastHourly> findByDayForecats(WeatherForecast p_weatherForecast, Date p_Day_forecast) {
		// TODO Auto-generated method stub
		return weatherForecastHourlyDAO.findByDayForecats(p_weatherForecast, p_Day_forecast);
	}

	@Override
	public WeatherForecastRecord findByDayForecatsRecord(WeatherForecast p_weatherForecast, Date p_Day_forecast) {
		// TODO Auto-generated method stub
		return weatherForecastHourlyDAO.findByDayForecatsRecord(p_weatherForecast, p_Day_forecast);
	}
    
}
