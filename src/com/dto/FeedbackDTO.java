package com.dto;

import java.util.ArrayList;
import java.util.List;

import com.bean.FeedbackBean;

public class FeedbackDTO extends GeneralDTO {
	private List<FeedbackBean> feedbacks ;

	public List<FeedbackBean> getFeedbacks() {
		return feedbacks;
	}

	public FeedbackDTO(boolean status, String message, List<FeedbackBean> allItem) {
		super(status, message);
		
		this.feedbacks = allItem;
	}
	public FeedbackDTO(){
		
	}
	@Override
	public String toString() {
		return "FeedbackDTO [feedbacks=" + feedbacks + ", status=" + status + ", message=" + message + "]";
	}

}
