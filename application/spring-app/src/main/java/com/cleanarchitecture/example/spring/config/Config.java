package com.cleanarchitecture.example.spring.config;

import com.cleanarchitecture.config.spring.SpringConfig;
import com.cleanarchitecture.example.controller.UserController;
import com.cleanarchitecture.example.usecase.CreateUser;
import com.cleanarchitecture.example.usecase.FindUser;
import com.cleanarchitecture.example.usecase.LoginUser;
import com.cleanarchitecture.example.usecase.port.UserRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	private final SpringConfig config;

	public Config(UserRepository userRepository) {
		config = new SpringConfig(userRepository);
	}

	@Bean
	public ObjectMapper objectMapper() {
		var objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return objectMapper;
	}

	@Bean
	public CreateUser createUser() {
		return config.createUser();
	}

	@Bean
	public FindUser findUser() {
		return config.findUser();
	}

	@Bean
	public LoginUser loginUser() {
		return config.loginUser();
	}

	@Bean
	public UserController userController() {
		return new UserController(createUser(), findUser(), loginUser());
	}
}
