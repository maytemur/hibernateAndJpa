package com.maytemur.project.hibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maytemur.project.hibernateAndJpa.DataAccess.ICityDal;
import com.maytemur.project.hibernateAndJpa.Entities.City;

@Service
public class CityManager implements ICityService {
	
	private ICityDal cityDal;
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> GetAll() {
		return this.cityDal.GetAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		//business-iş kuralları- burada şehir eklenecek ama if kontrolü ile daha önce
		//eklenmiş mi diye bakılır kodlar yazılır 
		this.cityDal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		return this.cityDal.getById(id);
	}

}
