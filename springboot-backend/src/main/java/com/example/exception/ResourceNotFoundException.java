package com.example.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ResourceNotFoundException() {
		super("Resource Not found Exception");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
