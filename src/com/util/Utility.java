package com.util;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.entity.*;
import org.apache.http.client.methods.*;
import org.apache.http.entity.*;
import org.apache.http.impl.client.*;
import org.codehaus.jackson.map.*;


public class Utility {
	public static String callPostJsonService(String servicePath,Object list)throws ClientProtocolException,IOException{
		
	
	String result="";
	HttpClient hc=new DefaultHttpClient();
	HttpPost hp=new HttpPost(servicePath);
    
	hp.addHeader("content-type", "application/json");
	StringWriter writer=new StringWriter();
	ObjectMapper om=new ObjectMapper();
	om.writeValue(writer,list);
	System.out.println("Writer" +writer);
	System.out.println("writer.getBuffer().toString()"+writer.getBuffer().toString());
	
	StringEntity se=new StringEntity(writer.getBuffer().toString());
	System.out.println("StringEntity"+se);
	hp.setEntity(se);
	
	HttpResponse hr=hc.execute(hp);
	
	InputStream in=hr.getEntity().getContent();
	System.out.println("Status is "+hr.getStatusLine().getStatusCode());
	BufferedReader br=new BufferedReader(new InputStreamReader(in));
	String data="",d="";
	System.out.println("hello1");
	while((d=br.readLine())!=null)
	{
		System.out.println("hello2");
		data+=d;
		System.out.println("hello3");
	}
	result=data;
	return result;
	}
	
	static public String callPostService(String servicePath,List<NameValuePair> v)throws ClientProtocolException,IOException{
		 System.out.println( "Request for service   ");
			
		String result="";
		HttpClient hc=new DefaultHttpClient();
		HttpPost hp=new HttpPost(servicePath);
	    hp.setEntity(new UrlEncodedFormEntity(v));
	    System.out.println("Servce will Be executed ");
	    HttpResponse hr=hc.execute(hp);
	    
	    System.out.println("executed ");
		  
		
		
		InputStream in=hr.getEntity().getContent();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String data="",d="";
		
		while((d=br.readLine())!=null)
		{
			
			data+=d;
			
		}
		result=data;
		 System.out.println( "Result is  " + data);
			
		return result;
		} 
	
	static public String callGetService(String servicePath,List<NameValuePair> v)throws ClientProtocolException,IOException{
		String result="";
		HttpClient hc=new DefaultHttpClient();
		HttpGet hp=new HttpGet(servicePath);
		 HttpResponse hr=hc.execute(hp);
		 InputStream in=hr.getEntity().getContent();
				 BufferedReader br=new BufferedReader(new InputStreamReader(in));
		 String data="",d="";
			
			while((d=br.readLine())!=null)
			{
				
				data+=d;
				
			}
			result=data;
			return result;
		}
	
static public String callGetService(String servicePath)throws ClientProtocolException,IOException{
	String result="";
	HttpClient hc=new DefaultHttpClient();
	HttpGet hp=new HttpGet(servicePath);
	 HttpResponse hr=hc.execute(hp);
	 InputStream in=hr.getEntity().getContent();
			 BufferedReader br=new BufferedReader(new InputStreamReader(in));
	 String data="",d="";
		
		while((d=br.readLine())!=null)
		{
			
			data+=d;
			
		}
		result=data;
		return result;
		} 
}
		
	
	
	
	
	
	
	
	
	
	


