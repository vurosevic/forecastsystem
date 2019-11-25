package deloitte.forecastsystem_bih.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.PreparedDataLoadHours;

public interface PreparedDataLoadHoursService {
	
	Optional<PreparedDataLoadHours> findById(Long id);	
    public List<PreparedDataLoadHours> findByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);
    public Double findRealByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);	
    public double[] getAllRealDataLoadHoursByCountry(Country p_country);

    public int[] getAllGodinaLoadHoursByCountry(Country p_country);
    public int[] getAllMesecLoadHoursByCountry(Country p_country);    
    public int[] getAllDanLoadHoursByCountry(Country p_country);
    public int[] getAllHourLoadHoursByCountry(Country p_country);   
}
