package com.bean;

import java.io.Serializable;

public class StuRegBean implements Serializable  {
	private String sid;
	private String name;
	private String email;
	private String password;
	private String mobie_no;
	public StuRegBean(){}
	
	public StuRegBean( String name, String email, String password, String mobie_no) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobie_no = mobie_no;
	}
	public StuRegBean(String sid, String name, String email, String password, String mobie_no) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobie_no = mobie_no;
	}
	@Override
	public String toString() {
		return "StuRegBean [sid=" + sid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobie_no=" + mobie_no + "]";
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobie_no() {
		return mobie_no;
	}
	public void setMobie_no(String mobie_no) {
		this.mobie_no = mobie_no;
	}
	

}
