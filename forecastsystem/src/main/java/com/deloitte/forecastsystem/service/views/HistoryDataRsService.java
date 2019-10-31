package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataRs;

public interface HistoryDataRsService {

	Optional<HistoryDataRs> findById(Long id);
    public List<HistoryDataRs> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
