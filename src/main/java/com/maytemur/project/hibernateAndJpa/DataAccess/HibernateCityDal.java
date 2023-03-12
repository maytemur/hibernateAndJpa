package com.maytemur.project.hibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maytemur.project.hibernateAndJpa.Entities.City;

/*Hİbernate'de bir sessionfactory ve bir session açıyorduk. Bu noktada standart olan JPA
 * (Java Persistence Api) devreye giriyor.JPA ilk etapta bir veri erişim tekniği ORM 
 * olarak ortaya çıkmışken daha sonra Java'da bir standart haline geldi. Hibernate'de 
 * Spring'de standart olarak JPA yı implement ediyor. Bunun sebebi sizin istediğiniz 
 * implementasyona hızlı bir şekilde geçmenize yarıyor.İsterseniz hibernate isterseniz 
 * bir başkasına geçebiliyoruz.JPA ile burada hibernate'i otomatik olarak injection 
 * yapıcaz.*/

@Repository
public class HibernateCityDal implements ICityDal {

	private EntityManager entityManager;

	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional // Bu olay AOP(Aspect Oriented Programming) olarak geçiyor
	// Bu kod Build olduğunda Session'ın önüne ve arkasına bir adet Transaction
	// ekliyor
	// bunu springFrameWork kullanarak import ediyoruz
	public List<City> GetAll() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City", City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
	}

	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, city.getId());
		session.delete(cityToDelete);

	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);

		City city = session.get(City.class, id);
		return city;
	}

}
