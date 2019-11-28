package deloitte.forecastsystem_bih.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

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

}
