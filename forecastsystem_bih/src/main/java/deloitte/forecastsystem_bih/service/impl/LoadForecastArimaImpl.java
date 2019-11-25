package deloitte.forecastsystem_bih.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deloitte.forecastsystem_bih.model.LoadForecastArima;
import deloitte.forecastsystem_bih.repository.LoadForecastArimaRepository;
import deloitte.forecastsystem_bih.service.LoadForecastArimaService;

@Service("loadForecastArimaService")
@Transactional
public class LoadForecastArimaImpl implements LoadForecastArimaService {
	
	@Autowired
	LoadForecastArimaRepository loadForecastArimaRepository;	

	@Override
	public List<LoadForecastArima> findAll() {
		// TODO Auto-generated method stub
		return loadForecastArimaRepository.findAll();
	}

	@Override
	public Optional<LoadForecastArima> findById(Long id) {
		// TODO Auto-generated method stub
		return loadForecastArimaRepository.findById(id); 
	}

	@Override
	public void delete(LoadForecastArima entity) {
		// TODO Auto-generated method stub
		loadForecastArimaRepository.delete(entity);
	}

	@Override
	public <S extends LoadForecastArima> S save(S entity) {
		// TODO Auto-generated method stub
		return loadForecastArimaRepository.save(entity);
	}

}
