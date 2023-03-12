package com.maytemur.project.hibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maytemur.project.hibernateAndJpa.Business.ICityService;
/*şu an tam bir backend uygulaması yaptık istersek artık bundan sonrası için bir paket daha
 * ekleyip örneğin swing(java için) uygulaması veya kotlin uygulaması veya restful ortam
 * veya angular ortam uygulamasını buraya ekleyebiliriz.Biz burada restful uygulaması
 * ekliyoruz*/
import com.maytemur.project.hibernateAndJpa.Entities.City;
// bazen paketler birbirlerini görmeyebiliyor!

@RestController
@RequestMapping("/api")
public class CityController {
	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")
	public List<City> get(){
		
		return cityService.GetAll();
	}
	
	@PostMapping ("/add")
	public void add(@RequestBody City city) {
		//Bunu postApi ile yapmak gerekiyor bunun için postman bedava versiyonunu kullandık
		//post- http://localhost:8080/api/add adresinde alt tarafta body seçili iken
		//daha alt menu'de raw seçili ve json formatında datayı gönderdik
		//status 200 ok dönerse işlem tamamdır
		cityService.add(city);
	}
	@PostMapping("/update")
	public void update (@RequestBody City city) {
		cityService.update(city);
	}
	@PostMapping("/delete")
	public void delete (@RequestBody City city) {
		cityService.delete(city);
	}
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id){
		
		return cityService.getById(id);
	}

}
