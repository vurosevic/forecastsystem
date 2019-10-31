package com.deloitte.forecastsystem.service.impl.views;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.forecastsystem.model.views.HistoryDataRo;
import com.deloitte.forecastsystem.repository.views.HistoryDataRoRepository;
import com.deloitte.forecastsystem.service.views.HistoryDataRoService;

@Service("historyDataRoService")
public class HistoryDataRoServiceImpl implements HistoryDataRoService {

	@Autowired
	HistoryDataRoRepository historyDataRoRepository;
	
	@Override
	public Optional<HistoryDataRo> findById(Long id) {
		// TODO Auto-generated method stub
		return historyDataRoRepository.findById(id);
	}

	@Override
	public List<HistoryDataRo> findByDate(Integer p_dan, Integer p_mesec, Integer p_godina) {
		// TODO Auto-generated method stub
		return historyDataRoRepository.findByDate(p_dan, p_mesec, p_godina);
	}

}
