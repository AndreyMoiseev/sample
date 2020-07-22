package com.example.shared;

import com.google.common.collect.ImmutableList;

public class ApiErrorResponse {
	private final ImmutableList<ValidationError> errors;

	public ApiErrorResponse(ImmutableList<ValidationError> fields) {
		this.errors = fields;
	}

	public ImmutableList<ValidationError> getErrors() {
		return errors;
	}
}
