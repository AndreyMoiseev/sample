package com.example.shared;

import com.google.common.collect.ImmutableList;

public class ValidationException extends RuntimeException {
	private final ImmutableList<ValidationError> errors;

	public ValidationException(ImmutableList<ValidationError> errors) {
		super("Validation error");

		this.errors = errors;
	}

	public ImmutableList<ValidationError> getErrors() {
		return errors;
	}
}
