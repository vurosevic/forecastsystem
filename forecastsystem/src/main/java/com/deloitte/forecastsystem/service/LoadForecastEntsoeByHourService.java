package com.deloitte.forecastsystem.service;

import java.util.Date;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastSumRecord;

public interface LoadForecastEntsoeByHourService {

    public LoadEntsoeForecastSumRecord findByDateForecastSumRecord(Date p_dateOfForecast, Country p_country, Date p_loadDate);
	
}
