package com.deloitte.forecastsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.PreparedDataLoadAvg;

public interface PreparedDataLoadAvgService {
	
	Optional<PreparedDataLoadAvg> findById(Long id);	
    public List<PreparedDataLoadAvg> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);	
    public Double findRealByDate(Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);
    public double[] getAllRealDataLoadAvgByCountry(Country p_country);

}
