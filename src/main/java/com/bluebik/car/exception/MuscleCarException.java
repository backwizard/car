package com.bluebik.car.exception;

public class MuscleCarException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public MuscleCarException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public MuscleCarException() {
		super();
	}
}
