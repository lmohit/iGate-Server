package com.application.iGate.model;

public enum Status {

	SUCCESS("200", "Success"),
	DB_EXCEPTION("100", "DB Exception"),
	FAILURE("500", "Failure");
	
	String code;
	String msg;
	
	Status(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
