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
import deloitte.forecastsystem_bih.model.Weather;
import deloitte.forecastsystem_bih.model.WeatherForecast;
import deloitte.forecastsystem_bih.repository.WeatherRepository;
import deloitte.forecastsystem_bih.service.WeatherService;

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

	@Override
	public Date lastDate(Country p_country) {
		// TODO Auto-generated method stub
		return weatherDAO.lastDate(p_country);
	}
    
}
