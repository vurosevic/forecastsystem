package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataHu;
import com.deloitte.forecastsystem.repository.views.HistoryDataHuRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataHuService;

@Service("historyDataHuService")
public class HistoryDataHuServiceImpl implements HistoryDataHuService {

	@Autowired
	HistoryDataHuRepository historyDataHuRepository;
	
	@Override
	public Optional<HistoryDataHu> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataHuRepository.findById(id);
	}

	@Override
	public List<HistoryDataHu> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataHuRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}
