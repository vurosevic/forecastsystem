package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataSk;

public interface HistoryDataSkService {

	Optional<HistoryDataSk> findById(Long id);
    public List<HistoryDataSk> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
