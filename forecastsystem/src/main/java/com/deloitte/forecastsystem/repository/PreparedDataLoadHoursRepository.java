package com.deloitte.forecastsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.PreparedDataLoadHours;

@Repository("preparedDataLoadHoursRepository")
public interface PreparedDataLoadHoursRepository extends CrudRepository<PreparedDataLoadHours, Long> {
	
	@Override
	Optional<PreparedDataLoadHours> findById(Long id);
	
    @Query("SELECT pdlh FROM PreparedDataLoadHours pdlh WHERE loadHour=:p_load_hour AND dan=:p_dan AND mesec=:p_mesec AND godina=:p_godina AND country=:p_country")
    public List<PreparedDataLoadHours> findByDate(@Param("p_load_hour") Integer p_load_hour, @Param("p_dan") Integer p_dan, @Param("p_mesec") Integer p_mesec, @Param("p_godina") Integer p_godina, @Param("p_country") Country p_country);

    @Query("SELECT pdlh.avgLoadRealData FROM PreparedDataLoadHours pdlh WHERE loadHour=:p_load_hour AND dan=:p_dan AND mesec=:p_mesec AND godina=:p_godina AND country=:p_country")
    public Double findRealByDate(@Param("p_load_hour") Integer p_load_hour, @Param("p_dan") Integer p_dan, @Param("p_mesec") Integer p_mesec, @Param("p_godina") Integer p_godina, @Param("p_country") Country p_country);
	
    @Query("SELECT pdlh.avgLoadRealData FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public double[] getAllRealDataLoadHoursByCountry(@Param("p_country") Country p_country);

}
