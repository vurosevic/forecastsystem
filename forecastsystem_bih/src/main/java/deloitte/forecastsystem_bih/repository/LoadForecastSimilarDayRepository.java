package deloitte.forecastsystem_bih.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.LoadForecastSimilarDay;

public interface LoadForecastSimilarDayRepository extends CrudRepository<LoadForecastSimilarDay, Long> {
	
	@Override
	List<LoadForecastSimilarDay> findAll();
	
	@Override
	Optional<LoadForecastSimilarDay> findById(Long id);
	
	@Override
	void delete(LoadForecastSimilarDay entity);

	@Override
	<S extends LoadForecastSimilarDay> S save(S entity);	

    @Query("SELECT lfsd.loadForecastSimilarDay FROM LoadForecastSimilarDay lfsd WHERE country=:p_country AND loadDate=:p_loadDate AND loadHour=:p_loadHour ORDER BY forecastDate DESC")
    public List<Double> findByDateLoadAndHour(@Param("p_country") Country p_country, @Param("p_loadDate") Date p_loadDate, 
                                           @Param("p_loadHour") Integer p_loadHour); 	
	
}
