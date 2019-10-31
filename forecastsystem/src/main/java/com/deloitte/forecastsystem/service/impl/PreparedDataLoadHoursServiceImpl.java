package com.deloitte.forecastsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.PreparedDataLoadHours;
import com.deloitte.forecastsystem.repository.PreparedDataLoadHoursRepository;
import com.deloitte.forecastsystem.service.PreparedDataLoadHoursService;

@Service("preparedDataLoadHoursService") 
public class PreparedDataLoadHoursServiceImpl implements PreparedDataLoadHoursService {

	@Autowired
	PreparedDataLoadHoursRepository preparedDataLoadHoursRepository;
	
	@Override
	public Optional<PreparedDataLoadHours> findById(Long id) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.findById(id);
	}

	@Override
	public List<PreparedDataLoadHours> findByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina,
			Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.findByDate(p_load_hour, p_dan, p_mesec, p_godina, p_country);
	}

	@Override
	public Double findRealByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina,
			Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.findRealByDate(p_load_hour, p_dan, p_mesec, p_godina, p_country);
	}

}
