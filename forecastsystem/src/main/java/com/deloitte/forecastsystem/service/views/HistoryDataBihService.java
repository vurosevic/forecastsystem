package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataBih;
public interface HistoryDataBihService {
	
	Optional<HistoryDataBih> findById(Long id);
    public List<HistoryDataBih> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);
	
}