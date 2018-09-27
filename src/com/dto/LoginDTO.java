package com.dto;

import com.bean.StuRegBean;

public class LoginDTO extends GeneralDTO {
	private StuRegBean login;

	public StuRegBean getLogin() {
		return login;
	}
	public LoginDTO() {}
		
	public LoginDTO(boolean status, String message, StuRegBean login) {
		super(status, message);
		this.login = login;
	}

	@Override
	public String toString() {
		return "LoginDTO [login=" + login + ", status=" + status + ", message=" + message + "]";
	}

}
