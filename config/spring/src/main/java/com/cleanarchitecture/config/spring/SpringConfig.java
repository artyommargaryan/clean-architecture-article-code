package com.cleanarchitecture.config.spring;

import com.cleanarchitecture.example.usecase.port.PasswordEncoder;
import com.cleanarchitecture.example.usecase.port.UserRepository;
import com.cleanarchitecture.example.encoder.Sha256PasswordEncoder;
import com.cleanarchitecture.example.usecase.CreateUser;
import com.cleanarchitecture.example.usecase.FindUser;
import com.cleanarchitecture.example.usecase.LoginUser;
import com.cleanarchitecture.example.uuid.UuidGenerator;

public class SpringConfig {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public SpringConfig(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, new UuidGenerator());
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}
