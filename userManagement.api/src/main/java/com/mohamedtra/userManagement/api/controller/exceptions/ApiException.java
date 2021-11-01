package com.mohamedtra.userManagement.api.controller.exceptions;

public class ApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4084469028531589930L;
	
	private final ErrorResource errorResource;
	
	public ApiException(ErrorResource errorResource) {
		super();
		this.errorResource = errorResource;
	}
	public ErrorResource getErrorResource() {
		return errorResource;
	}

}
