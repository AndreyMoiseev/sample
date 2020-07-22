package com.example.rest.dto;

import com.example.shared.ValidationError;
import com.google.common.collect.ImmutableList;

public final class Product {
	private String name;
	private String code;

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public ImmutableList<ValidationError> validate(String rootPath) {
		var builder = ImmutableList.<ValidationError>builder();

		if (name == null || name.isEmpty()) {
			builder.add(new ValidationError(rootPath + ".name", "Mandatory field is missing."));
		}

		if (code == null || code.isEmpty()) {
			builder.add(new ValidationError(rootPath + ".code", "Mandatory field is missing."));
		} else if (code.length() != 13) {
			builder.add(new ValidationError(rootPath + ".code", "Field length should be exactly 13."));
		}

		return builder.build();
	}
}
