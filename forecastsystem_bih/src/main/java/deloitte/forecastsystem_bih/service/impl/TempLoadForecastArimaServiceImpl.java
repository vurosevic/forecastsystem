package deloitte.forecastsystem_bih.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.TempLoadForecastArima;
import deloitte.forecastsystem_bih.repository.TempLoadForecastArimaRepository;
import deloitte.forecastsystem_bih.service.TempLoadForecastArimaService;

@Service("tempLoadForecastArimaService")
@Transactional	
public class TempLoadForecastArimaServiceImpl implements TempLoadForecastArimaService {

	@Autowired 
	TempLoadForecastArimaRepository tempLoadForecastArimaRepository; 
	
	@Override
	public List<TempLoadForecastArima> findAll() {
		// TODO Auto-generated method stub
		return tempLoadForecastArimaRepository.findAll();
	}

	@Override
	public Optional<TempLoadForecastArima> findById(Long id) {
		// TODO Auto-generated method stub
		return tempLoadForecastArimaRepository.findById(id);
	}

	@Override
	public void delete(TempLoadForecastArima entity) {
		// TODO Auto-generated method stub
		tempLoadForecastArimaRepository.delete(entity);
	}

	@Override
	public <S extends TempLoadForecastArima> S save(S entity) {
		// TODO Auto-generated method stub
		return tempLoadForecastArimaRepository.save(entity);
	}

	@Override
	public List<Double> findByDateLoadAndHour(Country p_country, Date p_loadDate, Integer p_loadHour) {
		// TODO Auto-generated method stub
		return tempLoadForecastArimaRepository.findByDateLoadAndHour(p_country, p_loadDate, p_loadHour);
	}

}
