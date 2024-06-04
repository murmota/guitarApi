package com.example.guitarApi;

import com.example.guitarApi.dal.DataAccessLayer;
import com.example.guitarApi.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class GuitarApiApplication {
	public static ApplicationContext context;
	public static User currentUser = null;
	public static void main(String[] args) {
		SpringApplication.run(GuitarApiApplication.class, args);

	}
}