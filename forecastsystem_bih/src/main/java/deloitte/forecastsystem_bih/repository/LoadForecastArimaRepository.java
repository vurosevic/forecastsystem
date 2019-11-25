package deloitte.forecastsystem_bih.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import deloitte.forecastsystem_bih.model.LoadForecastArima;

public interface LoadForecastArimaRepository extends CrudRepository<LoadForecastArima, Long> {
	
	@Override
	List<LoadForecastArima> findAll();
	
	@Override
	Optional<LoadForecastArima> findById(Long id);
	
	@Override
	void delete(LoadForecastArima entity);

	@Override
	<S extends LoadForecastArima> S save(S entity);
	
}
