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
import org.springframework.transaction.annotation.Transactional;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.Weather;
import com.deloitte.forecastsystem.model.WeatherForecast;
import com.deloitte.forecastsystem.repository.WeatherRepository;
import com.deloitte.forecastsystem.service.WeatherService;

/**
 *
 * @author Vladimir
 */
@Service("weatherService")
@Transactional
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherRepository weatherDAO;
    
    @Override
    public List<Weather> findAll() {
        return weatherDAO.findAll();
    }

    @Override
    public Optional<Weather> findById(Long id) {
        return weatherDAO.findById(id);
    }

    @Override
    public void delete(Weather t) {
        weatherDAO.delete(t);
    }

    @Override
    public <S extends Weather> S save(S s) {
        return weatherDAO.save(s);
    }

	@Override
	public WeatherForecast findByDate(Date p_forecastTime, Country p_country) {
		// TODO Auto-generated method stub
		return weatherDAO.findByDate(p_forecastTime, p_country);
	}
    
}
