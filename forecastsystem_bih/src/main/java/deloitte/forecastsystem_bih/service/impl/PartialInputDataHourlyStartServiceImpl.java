package deloitte.forecastsystem_bih.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.model.PartialInputDataHourlyStart;
import deloitte.forecastsystem_bih.repository.PartialInputDataHourlyStartRepository;
import deloitte.forecastsystem_bih.service.PartialInputDataHourlyStartService;

@Service("partialInputDataHourlyStartService") 
public class PartialInputDataHourlyStartServiceImpl implements PartialInputDataHourlyStartService {

	@Autowired
	PartialInputDataHourlyStartRepository partialInputDataHourlyStartRepository;
	
	@Override
	public List<PartialInputDataHourlyStart> findAll() {
		// TODO Auto-generated method stub
		return partialInputDataHourlyStartRepository.findAll();
	}

}
