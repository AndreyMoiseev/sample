package com.example.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<ApiErrorResponse> handleNotFound(ValidationException ex, WebRequest request) {
		logger.error("Exception", ex);

		return new ResponseEntity<>(new ApiErrorResponse(ex.getErrors()), HttpStatus.BAD_REQUEST);
	}
}
