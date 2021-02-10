package com.application.iGate.model;

import java.io.Serializable;

public class ResponseWrapper<T> implements Serializable {
	
	private T result;
	
	private Status status;
	
	private static ResponseWrapper<String> successResponse = new ResponseWrapper<String>("Operation Successfully Performed", Status.SUCCESS);
	private static ResponseWrapper<String> failureResponse = new ResponseWrapper<String>("Operation Failed", Status.FAILURE);
	
	public ResponseWrapper(T result, Status status) {
		super();
		this.result = result;
		this.status = status;
	}
	
	public ResponseWrapper() {}
	
	public static <T> ResponseWrapper<String> getSuccessResponse() {
		return successResponse;
	}
	
	public static <T> ResponseWrapper<String> getFailureResponse(String message, Status status) {
		failureResponse.setResult(message);
		failureResponse.setStatus(status);
		return failureResponse;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public static ResponseWrapper<String> getFailureResponse() {
		return failureResponse;
	}

	public static void setFailureResponse(ResponseWrapper<String> failureResponse) {
		ResponseWrapper.failureResponse = failureResponse;
	}

	public static void setSuccessResponse(ResponseWrapper<String> successResponse) {
		ResponseWrapper.successResponse = successResponse;
	}
	
}
