package deloitte.forecastsystem_bih.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.TempLoadForecastSimilarDay;

public interface TempLoadForecastSimilarDayService {
	
	List<TempLoadForecastSimilarDay> findAll();
	Optional<TempLoadForecastSimilarDay> findById(Long id);
	void delete(TempLoadForecastSimilarDay entity);
	<S extends TempLoadForecastSimilarDay> S save(S entity);
	
    public List<Double> findByDateLoadAndHour(@Param("p_country") Country p_country, @Param("p_loadDate") Date p_loadDate, 
                                           @Param("p_loadHour") Integer p_loadHour); 	

}
