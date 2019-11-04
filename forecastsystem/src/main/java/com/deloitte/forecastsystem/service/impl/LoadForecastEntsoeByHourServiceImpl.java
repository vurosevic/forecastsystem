package com.deloitte.forecastsystem.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastSumRecord;
import com.deloitte.forecastsystem.repository.views.LoadForecastEntsoeByHourRepository;
import com.deloitte.forecastsystem.service.LoadForecastEntsoeByHourService;

@Service("loadForecastEntsoeByHourService")
public class LoadForecastEntsoeByHourServiceImpl implements LoadForecastEntsoeByHourService {

	@Autowired
	LoadForecastEntsoeByHourRepository loadForecastEntsoeByHourRepository;
	
	@Override
	public LoadEntsoeForecastSumRecord findByDateForecastSumRecord(Date p_dateOfForecast, Country p_country,
			Date p_loadDate) {
		// TODO Auto-generated method stub
		return loadForecastEntsoeByHourRepository.findByDateForecastSumRecord(p_dateOfForecast, p_country, p_loadDate);
	}

}
