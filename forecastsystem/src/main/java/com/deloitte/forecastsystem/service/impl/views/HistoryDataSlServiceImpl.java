package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataSl;
import com.deloitte.forecastsystem.repository.views.HistoryDataSlRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataSlService;

@Service("historyDataSlService")
public class HistoryDataSlServiceImpl implements HistoryDataSlService {

	@Autowired
	HistoryDataSlRepository historyDataSlRepository;
	
	@Override
	public Optional<HistoryDataSl> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataSlRepository.findById(id);
	}

	@Override
	public List<HistoryDataSl> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataSlRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}