package com.maytemur.project.hibernateAndJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*src/main/resources altındaki application.properties dosyasında 
ilgili database connection bilgilerini injection yaptık */

/*Spring Boot Katmanlı yapılar- Database(mongo,sqlServer...) için bir uygulama
vasıtası ile buna bir bağlantı yaparız. En alt tabakada-DataAccess veri erişim katmanı
var burada Hibernate veya temel JDBC kodlarını veya Spring Data kodlarını burada yazarız.
bir üstü Business katmanıdır. İş kurallarının yazıldığı katmandır.Örneğin Ehliyet için
veritabanına bağlanıp ilkyardımdan vs vs 70 almışmı kontrol ediyoruz.Bunları DataAccess
katmanında bağımlı olmamak için yazmıyoruz.Bir üstü ise Service katmanıdır.RestApı vs
burada olur.Genelde yazılımcılar Business katmanını hiç koymayarak hepsini Service içinde
yazarlar bu yanlıştır çünkü örneğin biz burada RestFull geliştiricez ama yarın öbür gün
yepyeni bir şey çıkacak örneğin ABCfull bizim kodumuz Restfull içinde kaldı!!! Bir üstüde
UI (user Interface) dir. Katmanlı mimari için Resme bak. Bu katmanlar birbirleri ile 
interface'ler ile haberleşirler.*/

@SpringBootApplication
public class HibernateAndJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAndJpaApplication.class, args);
	}

}
