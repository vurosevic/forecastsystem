package deloitte.forecastsystem_bih.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.PreparedDataLoadHours;
import deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord;
import deloitte.forecastsystem_bih.repository.PreparedDataLoadHoursRepository;
import deloitte.forecastsystem_bih.service.PreparedDataLoadHoursService;

@Service("preparedDataLoadHoursService") 
public class PreparedDataLoadHoursServiceImpl implements PreparedDataLoadHoursService {

	@Autowired
	PreparedDataLoadHoursRepository preparedDataLoadHoursRepository;
	
	@Override
	public Optional<PreparedDataLoadHours> findById(Long id) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.findById(id);
	}

	@Override
	public List<PreparedDataLoadHours> findByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina,
			Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.findByDate(p_load_hour, p_dan, p_mesec, p_godina, p_country);
	}

	@Override
	public Double findRealByDate(Integer p_load_hour, Integer p_dan, Integer p_mesec, Integer p_godina,
			Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.findRealByDate(p_load_hour, p_dan, p_mesec, p_godina, p_country);
	}

	@Override
	public double[] getAllRealDataLoadHoursByCountry(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getAllRealDataLoadHoursByCountry(p_country);
	}

	@Override
	public int[] getAllGodinaLoadHoursByCountry(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getAllGodinaLoadHoursByCountry(p_country); 
	}

	@Override
	public int[] getAllMesecLoadHoursByCountry(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getAllMesecLoadHoursByCountry(p_country); 
	}

	@Override
	public int[] getAllDanLoadHoursByCountry(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getAllDanLoadHoursByCountry(p_country); 
	}

	@Override
	public int[] getAllHourLoadHoursByCountry(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getAllHourLoadHoursByCountry(p_country); 
	}

	@Override
	public List<PreparedDataLoadHoursRecord> getDataForSimilarDay(Country p_country, Long p_id, Integer p_load_hour) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getDataForSimilarDay(p_country, p_id, p_load_hour);
	}

	@Override
	public Double getDataForSimilarDayMaxTemp(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getDataForSimilarDayMaxTemp(p_country);
	}

	@Override
	public Double getDataForSimilarDayMaxFeelslike(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getDataForSimilarDayMaxFeelslike(p_country); 
	}

	@Override
	public Double getDataForSimilarDayMaxRealData(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getDataForSimilarDayMaxRealData(p_country); 
	}

	@Override
	public Double getDataForSimilarDayMinTemp(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getDataForSimilarDayMinTemp(p_country); 
	}

	@Override
	public Double getDataForSimilarDayMinFeelslike(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getDataForSimilarDayMinFeelslike(p_country); 
	}

	@Override
	public Double getDataForSimilarDayMinRealData(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getDataForSimilarDayMinRealData(p_country); 
	}

	@Override
    public List<PreparedDataLoadHoursRecord> getDataForSimilarDay(Country p_country, Integer p_load_hour) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getDataForSimilarDay(p_country, p_load_hour);  
	}

	@Override
	public List<PreparedDataLoadHoursRecord> getDataForSimilarDay(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getDataForSimilarDay(p_country); 
	}

	@Override
	public Long getMinIndexForPartialData(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getMinIndexForPartialData(p_country);
	}

	@Override
	public Long getMaxIndexForPartialData(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getMaxIndexForPartialData(p_country);
	}

	@Override
	public long[] getAllIdsLoadHoursByCountry(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getAllIdsLoadHoursByCountry(p_country);
	}

	@Override
	public <S extends PreparedDataLoadHours> S save(S entity) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.save(entity);
	}

	@Override
	public void delete(PreparedDataLoadHours entity) {
		// TODO Auto-generated method stub
		preparedDataLoadHoursRepository.delete(entity);
	}

	@Override
	public List<PreparedDataLoadHours> getPartialData(Country p_country) {
		// TODO Auto-generated method stub
		return preparedDataLoadHoursRepository.getPartialData(p_country); 
	}

}
