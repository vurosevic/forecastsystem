package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataBih;
import com.deloitte.forecastsystem.repository.views.HistoryDataBihRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataBihService;

@Service("historyDataBihService")
public class HistoryDataBihServiceImpl implements HistoryDataBihService {

	@Autowired
	HistoryDataBihRepository historyDataBihRepository;
	
	@Override
	public Optional<HistoryDataBih> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataBihRepository.findById(id);
	}

	@Override
	public List<HistoryDataBih> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataBihRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}
