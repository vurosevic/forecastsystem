package deloitte.forecastsystem_bih.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import deloitte.forecastsystem_bih.model.PartialInputDataHourlyStart;

public interface PartialInputDataHourlyStartRepository extends CrudRepository<PartialInputDataHourlyStart, Long> {
	
	@Override
	List<PartialInputDataHourlyStart> findAll();

}
