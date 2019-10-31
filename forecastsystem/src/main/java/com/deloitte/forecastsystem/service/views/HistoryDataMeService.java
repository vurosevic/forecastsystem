package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataMe;

public interface HistoryDataMeService {

	Optional<HistoryDataMe> findById(Long id);
    public List<HistoryDataMe> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
