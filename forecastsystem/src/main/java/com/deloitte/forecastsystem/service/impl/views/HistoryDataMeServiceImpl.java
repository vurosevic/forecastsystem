package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataMe;
import com.deloitte.forecastsystem.repository.views.HistoryDataMeRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataMeService;

@Service("historyDataMeService")
public class HistoryDataMeServiceImpl implements HistoryDataMeService {

	@Autowired
	HistoryDataMeRepository historyDataMeRepository;
	
	@Override
	public Optional<HistoryDataMe> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataMeRepository.findById(id);
	}

	@Override
	public List<HistoryDataMe> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataMeRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}