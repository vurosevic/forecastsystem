package deloitte.forecastsystem_bih.service;

import java.util.List;

import deloitte.forecastsystem_bih.model.Country;

public interface CountryService {

	List<Country> findAll();
	Country findById(Long id);
	<S extends Country> S save(S entity);
	void delete(Country entity);	
	void delete(Long id);
	
}
