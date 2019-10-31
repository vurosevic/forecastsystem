package com.deloitte.forecastsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.forecastsystem.model.Country;
import com.deloitte.forecastsystem.model.PreparedDataLoadAvg;

@Repository("preparedDataLoadAvgRepository")
public interface PreparedDataLoadAvgRepository extends CrudRepository<PreparedDataLoadAvg, Long> {
	
	@Override
	Optional<PreparedDataLoadAvg> findById(Long id);
	
    @Query("SELECT pdla FROM PreparedDataLoadAvg pdla WHERE dan=:p_dan AND mesec=:p_mesec AND godina=:p_godina AND country=:p_country")
    public List<PreparedDataLoadAvg> findByDate(@Param("p_dan") Integer p_dan, @Param("p_mesec") Integer p_mesec, @Param("p_godina") Integer p_godina, @Param("p_country") Country p_country);

    @Query("SELECT pdla.avgLoadRealData FROM PreparedDataLoadAvg pdla WHERE dan=:p_dan AND mesec=:p_mesec AND godina=:p_godina AND country=:p_country")
    public Double findRealByDate(@Param("p_dan") Integer p_dan, @Param("p_mesec") Integer p_mesec, @Param("p_godina") Integer p_godina, @Param("p_country") Country p_country);
    

}
