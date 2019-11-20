/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.forecastsystem_bih.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deloitte.forecastsystem_bih.model.Country;
import deloitte.forecastsystem_bih.model.Load;
import deloitte.forecastsystem_bih.repository.LoadRepository;
import deloitte.forecastsystem_bih.service.LoadService;

/**
 *
 * @author Vladimir
 */
@Service("loadService")
@Transactional
public class LoadSeviceImpl implements LoadService {

    @Autowired
    LoadRepository loadDAO;
    
    @Override
    public List<Load> findAll() {
        return loadDAO.findAll();
    }

    @Override
    public Optional<Load> findById(Long id) {
        return loadDAO.findById(id);
    }

    @Override
    public void delete(Load t) {
        loadDAO.delete(t);
    }

    @Override
    public <S extends Load> S save(S s) {
        return loadDAO.save(s);
    }

	@Override
	public Double getRealAvgLoadByDate(Date p_date, Country p_country) {
		// TODO Auto-generated method stub
		return loadDAO.getRealAvgLoadByDate(p_date, p_country);
	}

	@Override
	public Double getRealMinLoadByDate(Date p_date, Country p_country) {
		// TODO Auto-generated method stub
		return loadDAO.getRealMinLoadByDate(p_date, p_country);
	}

	@Override
	public Double getRealMaxLoadByDate(Date p_date, Country p_country) {
		// TODO Auto-generated method stub
		return loadDAO.getRealMaxLoadByDate(p_date, p_country);
	}
    
}
