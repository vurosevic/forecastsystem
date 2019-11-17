package com.deloitte.forecastsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.PreparedDataLoadAvg;
import com.deloitte.forecastsystem.repository.PreparedDataLoadAvgRepository;
import com.deloitte.forecastsystem.service.PreparedDataLoadAvgService;

@Service("preparedDataLoadAvgService")
public class PreparedDataLoadAvgServiceImpl implements PreparedDataLoadAvgService {

	@Autowired
	PreparedDataLoadAvgRepository preparedDataLoadAvgRepository;
	
	@Override
	public Optional<PreparedDataLoadAvg> findById(Long id) {
		// TODO Auto-generated method stub
		return preparedDataLoadAvgRepository.findById(id);
	}

	@Override
	public List<PreparedDataLoadAvg> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadAvgRepository.findByDate(p_dan, p_mesec, p_godina, p_country);
	}

	@Override
	public Double findRealByDate(Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadAvgRepository.findRealByDate(p_dan, p_mesec, p_godina, p_country); 
	}

	@Override
	public double[] getAllRealDataLoadAvgByCountry(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadAvgRepository.getAllRealDataLoadAvgByCountry(p_country);  
	}
	
	

}
