package com.deloitte.forecastsystem.service.views;

import java.util.List;
import java.util.Optional;

import com.deloitte.forecastsystem.model.views.HistoryDataHu;

public interface HistoryDataHuService {

		Optional<HistoryDataHu> findById(Long id);
	    public List<HistoryDataHu> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina);

}
