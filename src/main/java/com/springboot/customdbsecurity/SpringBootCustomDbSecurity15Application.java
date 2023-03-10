package com.springboot.customdbsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.springboot.customdbsecurity.Repository.UsersRepository;

@SpringBootApplication
public class SpringBootCustomDbSecurity15Application  {



	public static void main(String[] args) {
		SpringApplication.run(SpringBootCustomDbSecurity15Application.class, args);
	}


	

}
