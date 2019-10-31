package com.deloitte.forecastsystem.repository.views;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.forecastsystem.model.views.HistoryDataRo;

@Repository("historyDataRoRepository")
public interface HistoryDataRoRepository extends CrudRepository<HistoryDataRo, Long> {

	@Override
	Optional<HistoryDataRo> findById(Long id);
	
    @Query("SELECT hdat FROM HistoryDataRo hdat WHERE dan=:p_dan AND mesec=:p_mesec AND godina=:p_godina")
    public List<HistoryDataRo> findByDate(@Param("p_dan") Integer p_dan, @Param("p_mesec") Integer p_mesec, @Param("p_godina") Integer p_godina);
	
}
