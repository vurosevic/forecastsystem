package deloitte.forecastsystem_bih.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.PreparedDataLoadSum;
import deloitte.forecastsystem_bih.repository.PreparedDataLoadSumRepository;
import deloitte.forecastsystem_bih.service.PreparedDataLoadSumService;

@Service("preparedDataLoadSumService") 
public class PreparedDataLoadSumServiceImpl implements PreparedDataLoadSumService {

	@Autowired
	PreparedDataLoadSumRepository preparedDataLoadSumRepository;
	
	@Override
	public Optional<PreparedDataLoadSum> findById(Long id) {
		// TODO Auto-generated method stub
		return preparedDataLoadSumRepository.findById(id);
	}

	@Override
	public List<PreparedDataLoadSum> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadSumRepository.findByDate(p_dan, p_mesec, p_godina, p_country); 
	}

	@Override
	public Double findRealByDate(Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadSumRepository.findRealByDate(p_dan, p_mesec, p_godina, p_country);
	}

	@Override
	public double[] getAllRealDataLoadSumByCountry(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadSumRepository.getAllRealDataLoadSumByCountry(p_country);
	}

}
