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

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.LoadForecastEntsoe;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastRecord;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastSumRecord;
import com.deloitte.forecastsystem.repository.LoadForecastEntsoeRepository;
import com.deloitte.forecastsystem.service.LoadForecastEntsoeService;

/**
 *
 * @author Vladimir
 */
@Service("loadForecastEntsoeService")
public class LoadForecastEntsoeServiceImpl implements LoadForecastEntsoeService {

    @Autowired
    LoadForecastEntsoeRepository loadForecastEntsoeDAO;
    
    @Override
    public List<LoadForecastEntsoe> findAll() {
        return loadForecastEntsoeDAO.findAll();
    }

    @Override
    public Optional<LoadForecastEntsoe> findById(Long id) {
        return loadForecastEntsoeDAO.findById(id);
    }

    @Override
    public <S extends LoadForecastEntsoe> S save(S s) {
        return loadForecastEntsoeDAO.save(s);
    }

    @Override
    public void delete(LoadForecastEntsoe t) {
        loadForecastEntsoeDAO.delete(t);
    }

    @Override
    public Integer findByParam(Date p_dateOfForecast, Country p_country, Date p_loadDate, Integer p_loadHour, Integer p_loadMinute) {
        return loadForecastEntsoeDAO.findByParam(p_dateOfForecast, p_country, p_loadDate, p_loadHour, p_loadMinute);
    }

    @Override
    public List<LoadForecastEntsoe> findByDateForecast(Date p_dateOfForecast) {
        return loadForecastEntsoeDAO.findByDateForecast(p_dateOfForecast);
    }

    @Override
    public List<LoadForecastEntsoe> findByDateForecastCountry(Date p_dateOfForecast, Country p_country) {
        return loadForecastEntsoeDAO.findByDateForecastCountry(p_dateOfForecast, p_country);
    }

    @Override
    public List<LoadForecastEntsoe> findByDateForecastCountryLoadDate(Date p_dateOfForecast, Country p_country, Date p_loadDate) {
        return loadForecastEntsoeDAO.findByDateForecastCountryLoadDate(p_dateOfForecast, p_country, p_loadDate);
    }

	@Override
	public LoadEntsoeForecastRecord findByDateForecastRecord(Date p_dateOfForecast, Country p_country,
			Date p_loadDate) {
		// TODO Auto-generated method stub
		return loadForecastEntsoeDAO.findByDateForecastRecord(p_dateOfForecast, p_country, p_loadDate);
	}

	@Override
	public LoadEntsoeForecastSumRecord findByDateForecastSumRecord(Date p_dateOfForecast, Country p_country,
			Date p_loadDate) {
		// TODO Auto-generated method stub
		return loadForecastEntsoeDAO.findByDateForecastSumRecord(p_dateOfForecast, p_country, p_loadDate); 
	}

	@Override
	public Double findByDateForeastAndHour(Date p_dateOfForecast, Country p_country, Date p_loadDate,
			Integer p_loadHour) {
		// TODO Auto-generated method stub
		return loadForecastEntsoeDAO.findByDateForeastAndHour(p_dateOfForecast, p_country, p_loadDate, p_loadHour);
	}
	
	

}
