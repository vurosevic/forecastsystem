package deloitte.forecastsystem_bih.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import deloitte.forecastsystem_bih.model.PartialInputDataHourlyComplete;

public interface PartialInputDataHourlyCompleteRepository extends CrudRepository<PartialInputDataHourlyComplete, Long> {

	@Override
	List<PartialInputDataHourlyComplete> findAll();

}
