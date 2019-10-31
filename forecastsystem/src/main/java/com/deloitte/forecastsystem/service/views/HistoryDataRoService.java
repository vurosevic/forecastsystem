package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataRo;

public interface HistoryDataRoService {

	Optional<HistoryDataRo> findById(Long id);
    public List<HistoryDataRo> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
