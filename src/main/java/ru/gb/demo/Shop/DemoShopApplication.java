package ru.gb.demo.Shop;

import org.apache.catalina.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import ru.gb.demo.Shop.repo.ProductRepo;

import java.sql.SQLException;

@SpringBootApplication
public class DemoShopApplication {
	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	};

	@Bean
	public HttpHeaders headers()
	{
		return new HttpHeaders();
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoShopApplication.class, args);
	}

}
