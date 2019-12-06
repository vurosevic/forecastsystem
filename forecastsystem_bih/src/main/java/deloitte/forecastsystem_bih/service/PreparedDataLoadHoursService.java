package deloitte.forecastsystem_bih.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.PreparedDataLoadHours;
import deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord;

public interface PreparedDataLoadHoursService {
	
	Optional<PreparedDataLoadHours> findById(Long id);	
	
	public Long getMinIndexForPartialData(Country p_country);
	public Long getMaxIndexForPartialData(Country p_country);	
	
    public List<PreparedDataLoadHoursRecord> getDataForSimilarDay(Country p_country, Long p_id, Integer p_load_hour);
    public List<PreparedDataLoadHoursRecord> getDataForSimilarDay(Country p_country); 
    public List<PreparedDataLoadHoursRecord> getDataForSimilarDay(Country p_country, Integer p_load_hour);
    
    public Double getDataForSimilarDayMaxTemp(Country p_country);
    public Double getDataForSimilarDayMaxFeelslike(Country p_country);
    public Double getDataForSimilarDayMaxRealData(Country p_country);
    public Double getDataForSimilarDayMinTemp(Country p_country);
    public Double getDataForSimilarDayMinFeelslike(Country p_country);
    public Double getDataForSimilarDayMinRealData(Country p_country);	
	
    public List<PreparedDataLoadHours> findByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);
    public Double findRealByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina, Country p_country);	
    public double[] getAllRealDataLoadHoursByCountry(Country p_country);

    public int[] getAllGodinaLoadHoursByCountry(Country p_country);
    public int[] getAllMesecLoadHoursByCountry(Country p_country);    
    public int[] getAllDanLoadHoursByCountry(Country p_country);
    public int[] getAllHourLoadHoursByCountry(Country p_country);   
}
