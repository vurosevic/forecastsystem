package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataGr;
import com.deloitte.forecastsystem.repository.views.HistoryDataGrRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataGrService;

@Service("historyDataGrService")
public class HistoryDataGrServiceImpl implements HistoryDataGrService {

	@Autowired
	HistoryDataGrRepository historyDataGrRepository;
	
	@Override
	public Optional<HistoryDataGr> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataGrRepository.findById(id);
	}

	@Override
	public List<HistoryDataGr> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataGrRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}