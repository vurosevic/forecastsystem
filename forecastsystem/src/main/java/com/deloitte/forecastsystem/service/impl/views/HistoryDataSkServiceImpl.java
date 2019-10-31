package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataSk;
import com.deloitte.forecastsystem.repository.views.HistoryDataSkRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataSkService;

@Service("historyDataSkService")
public class HistoryDataSkServiceImpl implements HistoryDataSkService {

	@Autowired
	HistoryDataSkRepository historyDataSkRepository;
	
	@Override
	public Optional<HistoryDataSk> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataSkRepository.findById(id);
	}

	@Override
	public List<HistoryDataSk> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataSkRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}