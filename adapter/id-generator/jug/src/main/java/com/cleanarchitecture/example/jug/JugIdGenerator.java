package com.cleanarchitecture.example.jug;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import com.cleanarchitecture.example.usecase.port.IdGenerator;

public class JugIdGenerator implements IdGenerator {

	@Override
	public String generate() {
		return generator().generate().toString().replaceAll("-", "");
	}

	private static NoArgGenerator generator() {
		return Generators.timeBasedGenerator(EthernetAddress.fromInterface());
	}
}
