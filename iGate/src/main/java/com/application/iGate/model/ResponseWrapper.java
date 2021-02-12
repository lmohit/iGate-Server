package com.application.iGate.model;

import java.io.Serializable;

public class ResponseWrapper<T> implements Serializable {
	
	private T result;
	
	private String msg;
	
	private int code;
	
	private static ResponseWrapper<String> successResponse = new ResponseWrapper(null, "Operation Successfully Performed", 200);
	private static ResponseWrapper<String> failureResponse = new ResponseWrapper<String>(null, "Operation Failure", 110);
	
	public ResponseWrapper(T result, String msg, int code) {
		super();
		this.result = result;
		this.msg = msg;
		this.code = code;
	}
	
	public ResponseWrapper() {}
	
	public static <T> ResponseWrapper<String> getSuccessResponse() {
		return successResponse;
	}
	
	public static <T> ResponseWrapper<String> getFailureResponse(String message, int code) {
		failureResponse.setMsg(message);
		failureResponse.setCode(code);
		return failureResponse;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
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
