package com.cleanarchitecture.example.uuid;

import com.cleanarchitecture.example.usecase.port.IdGenerator;
import java.util.UUID;

public class UuidGenerator implements IdGenerator {

	@Override
	public String generate() {
		return UUID.randomUUID().toString();
	}
}
