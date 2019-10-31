package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataSl;

public interface HistoryDataSlService {

	Optional<HistoryDataSl> findById(Long id);
    public List<HistoryDataSl> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);
	
}
