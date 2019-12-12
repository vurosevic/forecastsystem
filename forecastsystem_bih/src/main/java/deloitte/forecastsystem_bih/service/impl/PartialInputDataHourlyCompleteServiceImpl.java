package deloitte.forecastsystem_bih.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.model.PartialInputDataHourlyComplete;
import deloitte.forecastsystem_bih.repository.PartialInputDataHourlyCompleteRepository;
import deloitte.forecastsystem_bih.service.PartialInputDataHourlyCompleteService;

@Service("partialInputDataHourlyCompleteService")
public class PartialInputDataHourlyCompleteServiceImpl implements PartialInputDataHourlyCompleteService {

	@Autowired
	PartialInputDataHourlyCompleteRepository partialInputDataHourlyCompleteRepository;
	
	@Override
	public List<PartialInputDataHourlyComplete> findAll() {
		// TODO Auto-generated method stub
		return partialInputDataHourlyCompleteRepository.findAll();
	}

}
