package com.abeldevelop.courses.clients.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4695981656734149894L;

	public NotFoundException(String message) {
		super(message);
	}
}
