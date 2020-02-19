package com.abeldevelop.courses.clients.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -8752346287335269084L;

	public BadRequestException(String message) {
		super(message);
	}
}
