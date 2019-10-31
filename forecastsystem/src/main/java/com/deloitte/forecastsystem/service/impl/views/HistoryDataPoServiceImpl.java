package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataPo;
import com.deloitte.forecastsystem.repository.views.HistoryDataPoRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataPoService;

@Service("historyDataPoService")
public class HistoryDataPoServiceImpl implements HistoryDataPoService {

	@Autowired
	HistoryDataPoRepository historyDataPoRepository;
	
	@Override
	public Optional<HistoryDataPo> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataPoRepository.findById(id);
	}

	@Override
	public List<HistoryDataPo> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataPoRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}
