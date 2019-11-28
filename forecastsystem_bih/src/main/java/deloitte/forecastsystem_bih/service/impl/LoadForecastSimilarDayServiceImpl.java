package deloitte.forecastsystem_bih.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deloitte.forecastsystem_bih.model.LoadForecastSimilarDay;
import deloitte.forecastsystem_bih.repository.LoadForecastSimilarDayRepository;
import deloitte.forecastsystem_bih.service.LoadForecastSimilarDayService;

@Service("loadForecastSimilarDayService")
@Transactional
public class LoadForecastSimilarDayServiceImpl implements LoadForecastSimilarDayService {
	
	@Autowired
	LoadForecastSimilarDayRepository loadForecastSimilarDayRepository;

	@Override
	public List<LoadForecastSimilarDay> findAll() {
		// TODO Auto-generated method stub
		return loadForecastSimilarDayRepository.findAll();
	}

	@Override
	public Optional<LoadForecastSimilarDay> findById(Long id) {
		// TODO Auto-generated method stub
		return loadForecastSimilarDayRepository.findById(id);
	}

	@Override
	public void delete(LoadForecastSimilarDay entity) {
		// TODO Auto-generated method stub
		loadForecastSimilarDayRepository.delete(entity);
	}

	@Override
	public <S extends LoadForecastSimilarDay> S save(S entity) {
		// TODO Auto-generated method stub
		return loadForecastSimilarDayRepository.save(entity); 
	}

}
