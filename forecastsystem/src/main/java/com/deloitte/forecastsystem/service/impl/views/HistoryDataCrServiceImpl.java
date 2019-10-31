package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataCr;
import com.deloitte.forecastsystem.repository.views.HistoryDataCrRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataCrService;

@Service("historyDataCrService")
public class HistoryDataCrServiceImpl implements HistoryDataCrService {

	@Autowired
	HistoryDataCrRepository historyDataCrRepository;
	
	@Override
	public Optional<HistoryDataCr> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataCrRepository.findById(id);
	}

	@Override
	public List<HistoryDataCr> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataCrRepository.findByDate(p_dan, p_mesec, p_godina);
	}	
	
}