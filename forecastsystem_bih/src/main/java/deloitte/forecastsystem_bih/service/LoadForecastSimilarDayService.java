package deloitte.forecastsystem_bih.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.LoadForecastSimilarDay;

public interface LoadForecastSimilarDayService {

	List<LoadForecastSimilarDay> findAll();
	Optional<LoadForecastSimilarDay> findById(Long id);
	void delete(LoadForecastSimilarDay entity);
	<S extends LoadForecastSimilarDay> S save(S entity);		

    public List<Double> findByDateLoadAndHour(Country p_country, Date p_loadDate, Integer p_loadHour);	
}
