package com.application.iGate.model;

public class ResponseWrapper<T> {
	
	T result;
	
	Status status;
	
	private static ResponseWrapper<String> successResponse = new ResponseWrapper<String>("Success", Status.SUCCESS);
	private static ResponseWrapper<String> failureResponse = new ResponseWrapper<String>("Operation Failed", Status.FAILURE);
	
	public ResponseWrapper(T result, Status status) {
		super();
		this.result = result;
		this.status = status;
	}
	
	public static <T> ResponseWrapper<String> getSuccessResponse() {
		return successResponse;
	}
	
	public static <T> ResponseWrapper<String> getFailureResponse(Status status) { 
		failureResponse.status = status;
		return failureResponse;
	}
	
}
