package com.application.iGate.model;

public enum Status {
	
	SUCCESS (200),
	DB_EXCEPTION(110),
	FAILURE (302);
	
	private final int responseCode;
	
	private Status(int responseCode) {
		this.responseCode = responseCode;
	}
}
