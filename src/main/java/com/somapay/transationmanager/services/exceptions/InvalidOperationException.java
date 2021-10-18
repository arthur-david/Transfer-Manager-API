package com.somapay.transationmanager.services.exceptions;

public class InvalidOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidOperationException(String msg) {
		super(msg);
	}
	
	public InvalidOperationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
