package com.chess.controller.response;

public class ExceptionResponse {

	private final String errorMessage;

	public ExceptionResponse(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
