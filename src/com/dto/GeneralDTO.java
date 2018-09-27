package com.dto;

import java.io.Serializable;

public class GeneralDTO implements Serializable {
	boolean status;
	String message;
	public GeneralDTO() {
		
	}
	public GeneralDTO(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "GeneralDTO [status=" + status + ", message=" + message + "]";
	}

}
