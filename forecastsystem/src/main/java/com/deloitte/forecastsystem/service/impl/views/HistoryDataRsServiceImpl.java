package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataRs;
import com.deloitte.forecastsystem.repository.views.HistoryDataRsRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataRsService;

@Service("historyDataRsService")
public class HistoryDataRsServiceImpl implements HistoryDataRsService {

	@Autowired
	HistoryDataRsRepository historyDataRsRepository;
	
	@Override
	public Optional<HistoryDataRs> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataRsRepository.findById(id);
	}

	@Override
	public List<HistoryDataRs> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataRsRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}