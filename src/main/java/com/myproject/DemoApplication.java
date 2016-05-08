package com.myproject;

import com.myproject.domain.Shop;
import com.myproject.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	ShopService shopService;
	@Override
	public void run(String... strings) throws Exception {
		shopService.save(new Shop(1, "hoge","moemo"));
		shopService.save(new Shop(2, "fuga","moemo"));
		shopService.save(new Shop(3, "moge","moemo"));
		shopService.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}