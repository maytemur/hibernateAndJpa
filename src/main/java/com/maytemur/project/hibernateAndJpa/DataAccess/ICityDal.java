package com.maytemur.project.hibernateAndJpa.DataAccess;
import java.util.List;

import com.maytemur.project.hibernateAndJpa.Entities.City;

public interface ICityDal {
	
	List<City> GetAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
}
