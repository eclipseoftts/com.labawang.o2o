package com.labawang.utils;

public class ErrorInfo {

	private int code;
	private String error;

	public void clear(){
		this.code = 0;
		this.error = "";
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
}
