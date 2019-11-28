package deloitte.forecastsystem_bih.service;

import java.util.List;
import java.util.Optional;

import deloitte.forecastsystem_bih.model.LoadForecastSimilarDay;

public interface LoadForecastSimilarDayService {

	List<LoadForecastSimilarDay> findAll();
	Optional<LoadForecastSimilarDay> findById(Long id);
	void delete(LoadForecastSimilarDay entity);
	<S extends LoadForecastSimilarDay> S save(S entity);		
	
}
