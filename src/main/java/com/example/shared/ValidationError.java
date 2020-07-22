package com.example.shared;

public final class ValidationError {
	private final String fieldPath;
	private final String errorMessage;

	public ValidationError(String fieldPath, String errorMessage) {
		this.fieldPath = fieldPath;
		this.errorMessage = errorMessage;
	}

	public String getFieldPath() {
		return fieldPath;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
