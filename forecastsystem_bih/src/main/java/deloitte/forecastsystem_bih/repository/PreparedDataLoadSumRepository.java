package deloitte.forecastsystem_bih.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.PreparedDataLoadSum;

@Repository("preparedDataLoadSumRepository")
public interface PreparedDataLoadSumRepository extends CrudRepository<PreparedDataLoadSum, Long> {

	@Override
	Optional<PreparedDataLoadSum> findById(Long id);
	
    @Query("SELECT pdls FROM PreparedDataLoadSum pdls WHERE dan=:p_dan AND mesec=:p_mesec AND godina=:p_godina AND country=:p_country")
    public List<PreparedDataLoadSum> findByDate(@Param("p_dan") Integer p_dan, @Param("p_mesec") Integer p_mesec, @Param("p_godina") Integer p_godina, @Param("p_country") Country p_country);

    @Query("SELECT pdla.sumLoadRealData FROM PreparedDataLoadSum pdla WHERE dan=:p_dan AND mesec=:p_mesec AND godina=:p_godina AND country=:p_country")
    public Double findRealByDate(@Param("p_dan") Integer p_dan, @Param("p_mesec") Integer p_mesec, @Param("p_godina") Integer p_godina, @Param("p_country") Country p_country);
	
    @Query("SELECT pdla.sumLoadRealData FROM PreparedDataLoadSum pdla WHERE country=:p_country ORDER BY id")
    public double[] getAllRealDataLoadSumByCountry(@Param("p_country") Country p_country);
    
}
