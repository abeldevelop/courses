package com.abeldevelop.courses.clients.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		Map<String, Object> body = new HashMap<>();
		body.put("message", ex.getMessage());
		HttpStatus status = null;
		if(ex instanceof NotFoundException) {
			status = HttpStatus.NOT_FOUND;
		} else if(ex instanceof BadRequestException) {
			status = HttpStatus.BAD_REQUEST;
		} else if(ex instanceof AccessDeniedException) {
			status = HttpStatus.FORBIDDEN;
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(body, headers, status);
	}
}
