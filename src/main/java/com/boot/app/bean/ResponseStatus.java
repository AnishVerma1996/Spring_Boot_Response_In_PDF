package com.boot.app.bean;

public class ResponseStatus
{
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseStatus(String message) {
		super();
		this.message = message;
	}

	public ResponseStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ResponseStatus [message=" + message + "]";
	}
	

}
