package com.deloitte.forecastsystem.repository.views;


import java.util.Date;

import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastSumRecord;
import com.deloitte.forecastsystem.model.views.LoadForecastEntsoeByHour;

@Repository("loadForecastEntsoeByHourRepository")
public interface LoadForecastEntsoeByHourRepository extends CrudRepository<LoadForecastEntsoeByHour, Long> {
	
    @Query("SELECT new com.deloitte.forecastsystem.model.communication.LoadEntsoeForecastSumRecord(SUM(lfe.loadForecastEntsoe), MIN(lfe.loadForecastEntsoe), MAX(lfe.loadForecastEntsoe)) FROM LoadForecastEntsoeByHour lfe WHERE dateOfForecast=:p_dateOfForecast AND country=:p_country AND loadDate=:p_loadDate")
    public LoadEntsoeForecastSumRecord findByDateForecastSumRecord(@Param("p_dateOfForecast") @Temporal(TemporalType.DATE) Date p_dateOfForecast,
                                                    @Param("p_country") Country p_country, @Param("p_loadDate")  @Temporal(TemporalType.DATE)  Date p_loadDate);	

}
