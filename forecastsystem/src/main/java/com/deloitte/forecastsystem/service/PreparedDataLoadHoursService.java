package com.deloitte.forecastsystem.service;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.PreparedDataLoadHours;

public interface PreparedDataLoadHoursService {
	
	Optional<PreparedDataLoadHours> findById(Long id);	
    public List<PreparedDataLoadHours> findByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);
    public Double findRealByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);	

}
