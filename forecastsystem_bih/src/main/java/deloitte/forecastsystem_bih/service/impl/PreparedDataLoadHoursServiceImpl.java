package deloitte.forecastsystem_bih.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.PreparedDataLoadHours;
import deloitte.forecastsystem_bih.repository.PreparedDataLoadHoursRepository;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;

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

	@Override
	public double[] getAllRealDataLoadHoursByCountry(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getAllRealDataLoadHoursByCountry(p_country);
	}

}
