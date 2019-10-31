package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataCr;

public interface HistoryDataCrService {

	Optional<HistoryDataCr> findById(Long id);
    public List<HistoryDataCr> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
