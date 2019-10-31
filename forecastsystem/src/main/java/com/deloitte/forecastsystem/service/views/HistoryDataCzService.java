package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataCz;

public interface HistoryDataCzService {

	Optional<HistoryDataCz> findById(Long id);
    public List<HistoryDataCz> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
