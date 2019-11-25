package deloitte.forecastsystem_bih.service;

import java.util.List;
import java.util.Optional;

import deloitte.forecastsystem_bih.model.LoadForecastArima;

public interface LoadForecastArimaService {
	
	List<LoadForecastArima> findAll();
	Optional<LoadForecastArima> findById(Long id);
	void delete(LoadForecastArima entity);
	<S extends LoadForecastArima> S save(S entity);
		
}
