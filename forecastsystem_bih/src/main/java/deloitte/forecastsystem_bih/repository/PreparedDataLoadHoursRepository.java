package deloitte.forecastsystem_bih.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.PreparedDataLoadHours;
import deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord;

@Repository("preparedDataLoadHoursRepository")
public interface PreparedDataLoadHoursRepository extends CrudRepository<PreparedDataLoadHours, Long> {
	
	@Override
	Optional<PreparedDataLoadHours> findById(Long id);

    @Query("SELECT pdlh FROM PreparedDataLoadHours pdlh WHERE country=:p_country AND pdlh.avgLoadForecastArima4=0 AND pdlh.avgLoadForecastArima3=0 AND pdlh.avgLoadForecastArima2=0 AND pdlh.avgLoadForecastArima=0")
    public List<PreparedDataLoadHours> getPartialData(@Param("p_country") Country p_country);	
	
    @Query("SELECT MIN(pdlh.id) FROM PreparedDataLoadHours pdlh WHERE country=:p_country AND pdlh.avgLoadForecastArima4=0 AND pdlh.avgLoadForecastArima3=0 AND pdlh.avgLoadForecastArima2=0 AND pdlh.avgLoadForecastArima=0")
    public Long getMinIndexForPartialData(@Param("p_country") Country p_country);
    
    @Query("SELECT MAX(pdlh.id) FROM PreparedDataLoadHours pdlh WHERE country=:p_country AND pdlh.avgLoadForecastArima4=0 AND pdlh.avgLoadForecastArima3=0 AND pdlh.avgLoadForecastArima2=0 AND pdlh.avgLoadForecastArima=0")
    public Long getMaxIndexForPartialData(@Param("p_country") Country p_country);    
	
    @Query("SELECT new deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord(pdlh.id, pdlh.avgTemperature4, pdlh.avgFeelslike4, pdlh.avgLoadRealData4, pdlh.avgTemperature3, pdlh.avgFeelslike3, pdlh.avgLoadRealData3, pdlh.avgTemperature2, pdlh.avgFeelslike2, pdlh.avgLoadRealData2, pdlh.avgLoadRealData)  FROM PreparedDataLoadHours pdlh WHERE country=:p_country AND id < :p_id AND loadHour=:p_load_hour ORDER BY id")
    public List<PreparedDataLoadHoursRecord> getDataForSimilarDay(@Param("p_country") Country p_country, @Param("p_id") Long p_id, @Param("p_load_hour") Integer p_load_hour);

    @Query("SELECT new deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord(pdlh.id, pdlh.avgTemperature4, pdlh.avgFeelslike4, pdlh.avgLoadRealData4, pdlh.avgTemperature3, pdlh.avgFeelslike3, pdlh.avgLoadRealData3, pdlh.avgTemperature2, pdlh.avgFeelslike2, pdlh.avgLoadRealData2, pdlh.avgLoadRealData)  FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public List<PreparedDataLoadHoursRecord> getDataForSimilarDay(@Param("p_country") Country p_country);    
    
    @Query("SELECT new deloitte.forecastsystem_bih.model.communication.PreparedDataLoadHoursRecord(pdlh.id, pdlh.avgTemperature4, pdlh.avgFeelslike4, pdlh.avgLoadRealData4, pdlh.avgTemperature3, pdlh.avgFeelslike3, pdlh.avgLoadRealData3, pdlh.avgTemperature2, pdlh.avgFeelslike2, pdlh.avgLoadRealData2, pdlh.avgLoadRealData)  FROM PreparedDataLoadHours pdlh WHERE country=:p_country AND loadHour=:p_load_hour ORDER BY id")
    public List<PreparedDataLoadHoursRecord> getDataForSimilarDay(@Param("p_country") Country p_country, @Param("p_load_hour") Integer p_load_hour);    
    
    @Query("SELECT MAX(pdlh.avgTemperature4) FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public Double getDataForSimilarDayMaxTemp(@Param("p_country") Country p_country);
    
    @Query("SELECT MAX(pdlh.avgFeelslike4) FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public Double getDataForSimilarDayMaxFeelslike(@Param("p_country") Country p_country);
    
    @Query("SELECT MAX(pdlh.avgLoadRealData4) FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public Double getDataForSimilarDayMaxRealData(@Param("p_country") Country p_country);
    
    @Query("SELECT MIN(pdlh.avgTemperature4) FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public Double getDataForSimilarDayMinTemp(@Param("p_country") Country p_country);
    
    @Query("SELECT MIN(pdlh.avgFeelslike4) FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public Double getDataForSimilarDayMinFeelslike(@Param("p_country") Country p_country);
    
    @Query("SELECT MIN(pdlh.avgLoadRealData4) FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public Double getDataForSimilarDayMinRealData(@Param("p_country") Country p_country);    
	
    @Query("SELECT pdlh FROM PreparedDataLoadHours pdlh WHERE loadHour=:p_load_hour AND dan=:p_dan AND mesec=:p_mesec AND godina=:p_godina AND country=:p_country")
    public List<PreparedDataLoadHours> findByDate(@Param("p_load_hour") Integer p_load_hour, @Param("p_dan") Integer p_dan, @Param("p_mesec") Integer p_mesec, @Param("p_godina") Integer p_godina, @Param("p_country") Country p_country);

    @Query("SELECT pdlh.avgLoadRealData FROM PreparedDataLoadHours pdlh WHERE loadHour=:p_load_hour AND dan=:p_dan AND mesec=:p_mesec AND godina=:p_godina AND country=:p_country")
    public Double findRealByDate(@Param("p_load_hour") Integer p_load_hour, @Param("p_dan") Integer p_dan, @Param("p_mesec") Integer p_mesec, @Param("p_godina") Integer p_godina, @Param("p_country") Country p_country);

    @Query("SELECT pdlh.id FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public long[] getAllIdsLoadHoursByCountry(@Param("p_country") Country p_country);    
    
    @Query("SELECT pdlh.avgLoadRealData FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public double[] getAllRealDataLoadHoursByCountry(@Param("p_country") Country p_country);
    
    @Query("SELECT pdlh.godina FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public int[] getAllGodinaLoadHoursByCountry(@Param("p_country") Country p_country);
    
    @Query("SELECT pdlh.mesec FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public int[] getAllMesecLoadHoursByCountry(@Param("p_country") Country p_country);    

    @Query("SELECT pdlh.dan FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public int[] getAllDanLoadHoursByCountry(@Param("p_country") Country p_country);
    
    @Query("SELECT pdlh.loadHour FROM PreparedDataLoadHours pdlh WHERE country=:p_country ORDER BY id")
    public int[] getAllHourLoadHoursByCountry(@Param("p_country") Country p_country);    
    
    @Override
    <S extends PreparedDataLoadHours> S save(S entity);
    
    @Override
    void delete(PreparedDataLoadHours entity);
}
