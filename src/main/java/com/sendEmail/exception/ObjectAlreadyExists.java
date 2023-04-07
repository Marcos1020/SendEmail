package com.sendEmail.exception;

public class ObjectAlreadyExists extends Exception {
	private static final long serialVersionUID = 1L;
	public ObjectAlreadyExists(String message) {
		super(message);
	}
}
