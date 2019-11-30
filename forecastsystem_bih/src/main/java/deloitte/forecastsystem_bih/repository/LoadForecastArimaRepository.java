package deloitte.forecastsystem_bih.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
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
	
    @Query("SELECT lfa.loadForecastArima FROM LoadForecastArima lfa WHERE country=:p_country AND loadDate=:p_loadDate AND loadHour=:p_loadHour ORDER BY forecastDate DESC")
    public List<Double> findByDateLoadAndHour(@Param("p_country") Country p_country, @Param("p_loadDate") Date p_loadDate, 
                                           @Param("p_loadHour") Integer p_loadHour); 	
	
}
