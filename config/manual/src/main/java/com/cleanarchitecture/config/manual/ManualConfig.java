package com.cleanarchitecture.config.manual;

import com.cleanarchitecture.example.db.InMemoryUserRepository;
import com.cleanarchitecture.example.usecase.port.IdGenerator;
import com.cleanarchitecture.example.usecase.port.PasswordEncoder;
import com.cleanarchitecture.example.usecase.port.UserRepository;
import com.cleanarchitecture.example.encoder.Sha256PasswordEncoder;
import com.cleanarchitecture.example.jug.JugIdGenerator;
import com.cleanarchitecture.example.usecase.CreateUser;
import com.cleanarchitecture.example.usecase.FindUser;
import com.cleanarchitecture.example.usecase.LoginUser;

public class ManualConfig {
	private final UserRepository userRepository = new InMemoryUserRepository();
	private final IdGenerator idGenerator = new JugIdGenerator();
	private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

	public CreateUser createUser() {
		return new CreateUser(userRepository, passwordEncoder, idGenerator);
	}

	public FindUser findUser() {
		return new FindUser(userRepository);
	}

	public LoginUser loginUser() {
		return new LoginUser(userRepository, passwordEncoder);
	}
}
