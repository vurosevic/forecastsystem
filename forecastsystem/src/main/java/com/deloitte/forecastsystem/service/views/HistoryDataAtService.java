package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;
import com.deloitte.forecastsystem.model.views.HistoryDataAt;

public interface HistoryDataAtService {
	
	Optional<HistoryDataAt> findById(Long id);
    public List<HistoryDataAt> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);
	
}
