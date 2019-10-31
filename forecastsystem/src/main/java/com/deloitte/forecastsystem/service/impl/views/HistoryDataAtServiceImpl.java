package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataAt;
import com.deloitte.forecastsystem.repository.views.HistoryDataAtRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataAtService;

@Service("historyDataAtService")
public class HistoryDataAtServiceImpl implements HistoryDataAtService {

	@Autowired
	HistoryDataAtRepository historyDataAtRepository;
	
	@Override
	public Optional<HistoryDataAt> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataAtRepository.findById(id);
	}

	@Override
	public List<HistoryDataAt> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataAtRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}
