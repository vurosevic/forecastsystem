package com.deloitte.forecastsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.repository.CountryRepository;
import com.deloitte.forecastsystem.service.CountryService;

@Service("CountryService")
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public Country findById(Long id) {
		// TODO Auto-generated method stub
		return countryRepository.findById(id).get();
	}

	@Override
	public <S extends Country> S save(S entity) {
		// TODO Auto-generated method stub
		return countryRepository.save(entity);
	}

	@Override
	public void delete(Country entity) {
		// TODO Auto-generated method stub
		countryRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		countryRepository.deleteById(id);
	}

	
	
}
