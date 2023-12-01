package com.cleanarchitecture.example.encoder;

import com.cleanarchitecture.example.usecase.port.PasswordEncoder;
import org.apache.commons.codec.digest.DigestUtils;

public class Sha256PasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(final String str) {
		return DigestUtils.sha256Hex(str);
	}
}
