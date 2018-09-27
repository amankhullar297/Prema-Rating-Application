package com.bean;
import java.util.Scanner;
import com.bean.*;
import com.dao.FeedbackDao;
import com.dao.SturegDao;
public class Test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice");
		System.out.println("(1) For Student Register");
		System.out.println("(2) For Login");
		System.out.println("(3) For Feedback");
		System.out.println("(4) For Feedback View");
		System.out.println("(5) Exit");
		int c=sc.nextInt();
		boolean b=true;
		while(b) {
			switch(c) {
			case 1: System.out.println("Enter your id");
			 		String sid=sc.next();	
			 		System.out.println("Enter your name");
			 		String name=sc.next();
			 		System.out.println("Enter your email");
			 		String email=sc.next();	
			 		System.out.println("Enter your password");
			 		String password=sc.next();
			 		System.out.println("Enter your mobile no.");
			 		String mobie_no=sc.next();
					StuRegBean sb= new StuRegBean(sid, name, email, password, mobie_no);
					SturegDao sd=new SturegDao();
					sd.insertstu(sb);System.out.println(sd);
				break;
			case 2:
				System.out.println("Enter your email");
		 		String uname=sc.next();	
		 		System.out.println("Enter your password");
		 		String pass=sc.next();
		 		SturegDao sd1=new SturegDao();
				sd1.login(uname, pass);
				break;
			case 3:
				System.out.println("Enter fid");
		 		int fbid=sc.nextInt();	
		 		System.out.println("Enter sid");
		 		int fbsid=sc.nextInt();
		 		System.out.println("Enter your name");
		 		String fbname=sc.next();
		 		System.out.println("Enter course name ");
		 		String course_name=sc.next();	
		 		System.out.println("Enter your rating");
		 		int rating=sc.nextInt();
		 		FeedbackBean fb= new FeedbackBean(fbid, fbsid, fbname, course_name, rating);
		 		FeedbackDao fd=new FeedbackDao();
		 		fd.insertfeedback(fb);
		 		System.out.println(fb);
				break;
			case 4:System.out.println("Enter Course Name");
	 				String cname=sc.next();
	 				FeedbackDao fd1=new FeedbackDao();
	 				fd1.getFeedback(cname);
				break;
			case 5:System.out.println("Exited Sucessully");
					b=false;
			default:
			}//switch
		}//while
	}//main
}//class

