package deloitte.forecastsystem_bih.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.HistoryLoadForecast;
import deloitte.forecastsystem_bih.repository.HistoryLoadForecastRepository;
import deloitte.forecastsystem_bih.service.HistoryLoadForecastService;

@Service("historyLoadForecastService")
@Transactional
public class HistoryLoadForecastServiceImpl implements HistoryLoadForecastService {

	@Autowired 
	HistoryLoadForecastRepository historyLoadForecastRepository;
	
	@Override
	public List<HistoryLoadForecast> findAll() {
		// TODO Auto-generated method stub
		return historyLoadForecastRepository.findAll();
	}

	@Override
	public Optional<HistoryLoadForecast> findById(Long id) {
		// TODO Auto-generated method stub
		return historyLoadForecastRepository.findById(id);
	}

	@Override
	public void delete(HistoryLoadForecast entity) {
		// TODO Auto-generated method stub
		historyLoadForecastRepository.delete(entity);
	}

	@Override
	public <S extends HistoryLoadForecast> S save(S entity) {
		// TODO Auto-generated method stub
		return historyLoadForecastRepository.save(entity);
	}

	@Override
	public List<Double> findByDateLoadAndHour(Country p_country, Date p_loadDate, Integer p_loadHour) {
		// TODO Auto-generated method stub
		return historyLoadForecastRepository.findByDateLoadAndHour(p_country, p_loadDate, p_loadHour);
	}

}
