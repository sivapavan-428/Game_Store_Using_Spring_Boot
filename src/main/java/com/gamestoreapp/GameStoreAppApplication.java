package com.gamestoreapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gamestoreapp.serviceImpl.AuthService;

@SpringBootApplication
public class GameStoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameStoreAppApplication.class, args);
	}
	
	    @Bean
	    CommandLineRunner encodePasswords(AuthService authService) {
	        return args -> {
	            authService.encodeExistingPasswords();
	        };
	    }
}
