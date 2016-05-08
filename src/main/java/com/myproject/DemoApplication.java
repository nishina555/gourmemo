package com.myproject;

import com.myproject.domain.Shop;
import com.myproject.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	ShopRepository shopRepository;

	@Override
	public void run(String... strings) throws Exception {
		Shop created = shopRepository.save(new Shop(null, "hoge","moemo"));
		System.out.println(created + "is created !");
		shopRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}