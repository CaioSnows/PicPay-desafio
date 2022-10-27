package com.carteiradesafio.carteiraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // Não executar essa classe onde ele pede Usuário e senha
public class CarteiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarteiraApplication.class, args);
	}

}
