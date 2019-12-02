package deloitte.forecastsystem_bih.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.PreparedDataLoadSum;

public interface PreparedDataLoadSumService {

	Optional<PreparedDataLoadSum> findById(Long id);	
    public List<PreparedDataLoadSum> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);	
    public Double findRealByDate(Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);	
    public double[] getAllRealDataLoadSumByCountry(@Param("p_country") Country p_country);
}
