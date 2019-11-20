package deloitte.forecastsystem_bih.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import deloitte.forecastsystem_bih.model.Country;

@Repository("countryRepository")
public interface CountryRepository extends CrudRepository<Country, Long> {

	@Override
	List<Country> findAll();
	
	@Override
	Optional<Country> findById(Long id); 
	
	@Override
	<S extends Country> S save(S entity);
	
	@Override
	void delete(Country entity);
	
	@Override
	void deleteById(Long id);
	
}
