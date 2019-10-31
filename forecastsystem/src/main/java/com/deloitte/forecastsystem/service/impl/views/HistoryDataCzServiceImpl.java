package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataCz;
import com.deloitte.forecastsystem.repository.views.HistoryDataCzRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataCzService;

@Service("historyDataCzService")
public class HistoryDataCzServiceImpl implements HistoryDataCzService {

	@Autowired
	HistoryDataCzRepository historyDataCzRepository;
	
	@Override
	public Optional<HistoryDataCz> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataCzRepository.findById(id);
	}

	@Override
	public List<HistoryDataCz> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataCzRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}
