package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataGr;

public interface HistoryDataGrService {

	Optional<HistoryDataGr> findById(Long id);
    public List<HistoryDataGr> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
