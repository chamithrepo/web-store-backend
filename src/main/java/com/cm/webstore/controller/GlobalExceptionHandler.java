package com.cm.webstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.cm.webstore.exception.ErrorDetail;
import com.cm.webstore.exception.ResourceNotFoundException;


/**
 * @author Chamith_Madusanka
 *
 * Global Exception handler to handle all exception throwing from controllers
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private final static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
			WebRequest request) {
		LOG.error(String.format("Caught a Resource Not Found Exception %s", resourceNotFoundException.getMessage()));
		ErrorDetail errorDetails = new ErrorDetail(HttpStatus.NOT_FOUND.value(),
				resourceNotFoundException.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> exception(Exception exception, WebRequest request) {
		LOG.error(String.format("Caught a Internal Server Error %s", exception.getMessage()));
		ErrorDetail errorDetails = new ErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
