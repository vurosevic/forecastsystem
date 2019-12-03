package deloitte.forecastsystem_bih.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.LoadForecastArima;
import deloitte.forecastsystem_bih.model.TempLoadForecastArima;

public interface TempLoadForecastArimaRepository extends CrudRepository<TempLoadForecastArima, Long> {

	@Override
	List<TempLoadForecastArima> findAll();
	
	@Override
	Optional<TempLoadForecastArima> findById(Long id);
	
	@Override
	void delete(TempLoadForecastArima entity);

	@Override
	<S extends TempLoadForecastArima> S save(S entity);
	
    @Query("SELECT lfa.loadForecastArima FROM TempLoadForecastArima lfa WHERE country=:p_country AND loadDate=:p_loadDate AND loadHour=:p_loadHour ORDER BY forecastDate DESC")
    public List<Double> findByDateLoadAndHour(@Param("p_country") Country p_country, @Param("p_loadDate") Date p_loadDate, 
                                           @Param("p_loadHour") Integer p_loadHour); 	
	
}
