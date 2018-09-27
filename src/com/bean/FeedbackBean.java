package com.bean;

public class FeedbackBean {
	private int fbid;
	private int sid;
	private String name;
	private String course_name;
	private int rating;
	
	public int getFbid() {
		return fbid;
	}
	public void setFbid(int fbid) {
		this.fbid = fbid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public FeedbackBean(){
		
	}
	public FeedbackBean(int sid, String name, String course_name, int rating) {
		super();
		this.sid = sid;
		this.name = name;
		this.course_name = course_name;
		this.rating = rating;
	}
	public FeedbackBean(int fbid, int sid, String name, String course_name, int rating) {
		super();
		this.fbid = fbid;
		this.sid = sid;
		this.name = name;
		this.course_name = course_name;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "FeedbackBean [fbid=" + fbid + ", sid=" + sid + ", name=" + name + ", course_name=" + course_name
				+ ", rating=" + rating + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	

}
