package deloitte.forecastsystem_bih.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.TempLoadForecastSimilarDay;
import deloitte.forecastsystem_bih.repository.TempLoadForecastSimilarDayRepository;
import deloitte.forecastsystem_bih.service.TempLoadForecastSimilarDayService;

@Service("tempLoadForecastSimilarDayService")
@Transactional
public class TempLoadForecastSimilarDayServiceImpl implements TempLoadForecastSimilarDayService {

	@Autowired
	TempLoadForecastSimilarDayRepository tempLoadForecastSimilarDayRepository;
	
	@Override
	public List<TempLoadForecastSimilarDay> findAll() {
		// TODO Auto-generated method stub
		return tempLoadForecastSimilarDayRepository.findAll();
	}

	@Override
	public Optional<TempLoadForecastSimilarDay> findById(Long id) {
		// TODO Auto-generated method stub
		return tempLoadForecastSimilarDayRepository.findById(id);
	}

	@Override
	public void delete(TempLoadForecastSimilarDay entity) {
		// TODO Auto-generated method stub
		tempLoadForecastSimilarDayRepository.delete(entity);
	}

	@Override
	public <S extends TempLoadForecastSimilarDay> S save(S entity) {
		// TODO Auto-generated method stub
		return tempLoadForecastSimilarDayRepository.save(entity);
	}

	@Override
	public List<Double> findByDateLoadAndHour(Country p_country, Date p_loadDate, Integer p_loadHour) {
		// TODO Auto-generated method stub
		return tempLoadForecastSimilarDayRepository.findByDateLoadAndHour(p_country, p_loadDate, p_loadHour);
	}

}
