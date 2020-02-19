package com.abeldevelop.courses.clients.exception;

public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = -8752346287335269084L;

	public InternalServerErrorException(String message) {
		super(message);
	}
}
