package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataBl;

public interface HistoryDataBlService {

	Optional<HistoryDataBl> findById(Long id);
    public List<HistoryDataBl> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
