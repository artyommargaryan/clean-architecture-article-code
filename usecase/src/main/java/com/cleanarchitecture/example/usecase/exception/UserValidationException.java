package com.cleanarchitecture.example.usecase.exception;

public class UserValidationException extends RuntimeException {
	public UserValidationException(final String message) {
		super(message);
	}
}
