package deloitte.forecastsystem_bih.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.HistoryLoadForecast;

public interface HistoryLoadForecastService {

	List<HistoryLoadForecast> findAll();
	Optional<HistoryLoadForecast> findById(Long id);
	void delete(HistoryLoadForecast entity);
	<S extends HistoryLoadForecast> S save(S entity);
    public List<Double> findByDateLoadAndHour(@Param("p_country") Country p_country, @Param("p_loadDate") Date p_loadDate, 
                                              @Param("p_loadHour") Integer p_loadHour); 	
	
	
}
