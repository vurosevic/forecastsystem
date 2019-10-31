package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataPo;

public interface HistoryDataPoService {

	Optional<HistoryDataPo> findById(Long id);
    public List<HistoryDataPo> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
