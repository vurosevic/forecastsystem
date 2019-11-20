/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.Load;

/**
 *
 * @author Vladimir
 */
public interface LoadService {
    
    public List<Load> findAll();
    public Optional<Load> findById(Long id);
    public void delete(Load t);
    public <S extends Load> S save(S s);    
    
    public Double getRealAvgLoadByDate(Date p_date, Country p_country);
    public Double getRealMinLoadByDate(Date p_date, Country p_country);
    public Double getRealMaxLoadByDate(Date p_date, Country p_country);
    
}
