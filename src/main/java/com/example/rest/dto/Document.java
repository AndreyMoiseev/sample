package com.example.rest.dto;

import com.example.shared.ValidationError;
import com.example.shared.ValidationException;
import com.google.common.collect.ImmutableList;

import java.util.List;

public final class Document {
	private String seller;
	private String customer;
	private List<Product> products;

	public String getSeller() {
		return seller;
	}

	public String getCustomer() {
		return customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void validate() {
		var errors = validateInternal();
		if (!errors.isEmpty())
			throw new ValidationException(errors);
	}

	private ImmutableList<ValidationError> validateInternal() {
		var builder = ImmutableList.<ValidationError>builder();

		if (seller == null || seller.isEmpty()) {
			builder.add(new ValidationError("$.seller", "Mandatory field is missing."));
		} else if (seller.length() != 9) {
			builder.add(new ValidationError("$.seller", "Field length should be exactly 9."));
		}

		if (customer == null || customer.isEmpty()) {
			builder.add(new ValidationError("$.customer", "Mandatory filed is missing"));
		} else if (customer.length() != 9) {
			builder.add(new ValidationError("$.customer", "Field length should be exactly 9."));
		}

		if (products == null) {
			builder.add(new ValidationError("$.products", "Mandatory field is missing."));
		} else {
			for (int i = 0; i < products.size(); i++) {
				var rootPath = "$.products[" + i + "]";
				builder.addAll(products.get(i).validate(rootPath));
			}
		}

		return builder.build();
	}
}
