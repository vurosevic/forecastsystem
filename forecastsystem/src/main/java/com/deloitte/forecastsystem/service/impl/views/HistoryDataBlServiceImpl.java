package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataBl;
import com.deloitte.forecastsystem.repository.views.HistoryDataBlRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataBlService;

@Service("historyDataBlService")
public class HistoryDataBlServiceImpl implements HistoryDataBlService {

	@Autowired
	HistoryDataBlRepository historyDataBlRepository;
	
	@Override
	public Optional<HistoryDataBl> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataBlRepository.findById(id);
	}

	@Override
	public List<HistoryDataBl> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataBlRepository.findByDate(p_dan, p_mesec, p_godina);
	}	
	
}
