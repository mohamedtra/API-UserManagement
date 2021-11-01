package com.mohamedtra.userManagement.api.controller.exceptions;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorResource {
	
	private String label;
	private String detailMessageString;
	private HttpStatus status;
	
	/**
	 * Constructor to build error resource
	 * @param label
	 * @param detailMessageString
	 * @param status
	 */
	public ErrorResource(String label, String detailMessageString, HttpStatus status) {
		super();
		this.label = label;
		this.detailMessageString = detailMessageString;
		this.status = status;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDetailMessageString() {
		return detailMessageString;
	}

	public void setDetailMessageString(String detailMessageString) {
		this.detailMessageString = detailMessageString;
	}
	
	@JsonIgnore
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
	

}
