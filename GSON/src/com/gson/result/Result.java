package com.gson.result;

public class Result<T> {
	
	
	private String state;
	
	private String message;
	
	private T data;

	public Result(String state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
	
	
	

}
