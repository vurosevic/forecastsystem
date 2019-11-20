/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.Load;

/**
 *
 * @author Vladimir
 */
@Repository("loadDAO")
public interface LoadRepository extends CrudRepository<Load, Long>{

    @Override
    public List<Load> findAll();

    @Override
    public Optional<Load> findById(Long id);

    @Override
    public void delete(Load t);

    @Override
    public <S extends Load> S save(S s);
    
    @Query("SELECT AVG(loadRealData) FROM Load lo WHERE Load_date=:p_date AND country=:p_country")
    public Double getRealAvgLoadByDate(@Param("p_date") Date p_date, @Param("p_country") Country p_country);
  
    @Query("SELECT MIN(loadRealData) FROM Load lo WHERE Load_date=:p_date AND country=:p_country")
    public Double getRealMinLoadByDate(@Param("p_date") Date p_date, @Param("p_country") Country p_country);

    @Query("SELECT MAX(loadRealData) FROM Load lo WHERE Load_date=:p_date AND country=:p_country")
    public Double getRealMaxLoadByDate(@Param("p_date") Date p_date, @Param("p_country") Country p_country);

}
