package com.test.consultorio.shared.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ResponseApi<T>{

	private String code;
	private T body;
	private String message;
	
	public ResponseApi() {
		
	}
	
	public ResponseApi(String code, T body, String message) {
		super();
		this.code = code;
		this.body = body;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
