package com.maytemur.project.hibernateAndJpa.Business;

import java.util.List;

import com.maytemur.project.hibernateAndJpa.Entities.City;
//DataAccess altındaki kodlar ile aynı ama buradaki kodlar zaman içinde değişecek
//database ile alakası olmayan eklemeler vs yapaılabilecek buna signature deniliyor
//ayrıca iş kodu yönetimi için CİtyManager class'ı ekliyoruz

public interface ICityService {
	List<City> GetAll();

	void add(City city);

	void update(City city);

	void delete(City city);
	City getById(int id);

}
