package com.service;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

import com.sun.jersey.multipart.FormDataParam;

@Path("hello2")
public class Hello {

	public class E_Data {
		private String name;
		private String password;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		

	}
	
		
	@GET
	@Path("/hellojason")
	@Produces(MediaType.APPLICATION_JSON)
	public Vector <E_Data>getData() {
		
	Vector <E_Data> V = getDB_Data();
	return V;
}
	
	public Vector<E_Data>getDB_Data()
	{
		Vector<E_Data> V = new Vector<E_Data>();
		try
		{
			Connection cn = mydb_connection();
			PreparedStatement ps = cn.prepareStatement("select * from e_details1");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{E_Data ed = new E_Data();
			ed.setName(rs.getString("name"));
			ed.setPassword(rs.getString("password"));
			V.add(ed);
			}}
			catch (Exception e)
			{
				
			}
			return V;
			}
		
	@POST
	@Path("/Insert")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void Insert(@FormDataParam("name") String uid,
			@FormDataParam("password") String pwd)
	{
		//public void Insert(String uid,Stringpwd)
		//{
		Connection cn=mydb_connection();
		
		try
		{
			String query = "INSERT INTO e_details1(name, password) VALUES (?, ?)";
			PreparedStatement ps = cn.prepareStatement(query);            
			ps.setString(1, uid);  
			ps.setString(2, pwd);  
			ps.executeUpdate();  
			ps.close();  
		}
		catch (SQLException e) {}
		// {  
//throw new RuntimeException(e);  
			// } 
		//finally
		//{  
	//if (cn != null) {  
	//  try {  
	//  cn.close();  
//} catch (SQLException e) {}  
	//}
		// }
		}
		

	@GET
	@Path("/helloget")
	@Produces(MediaType.TEXT_PLAIN)
	public String wish()
	{
		
		return"Welcome";
	}
	
		@GET
		@Path("/hellobye")
		@Produces(MediaType.TEXT_PLAIN)
		public String bye(){
			
			return"goodbye";
			
		}
		@POST
		@Path("/isvalid")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.MULTIPART_FORM_DATA)
		public String check(@FormDataParam("name") String uid,
				@FormDataParam("password") String pwd)
		{
			if(isValid(uid,pwd))
			{
				return"valid";
			}
			else {
				return"invalid";
			}
			}
		
		
		public Connection mydb_connection() {
			try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL  = "jdbc:oracle:thin:@localhost:1521:xe"; //"jdbc:oracle:thin:@10.4.2.46:1521:testdb",
			String uid = "hr" ; //"trng",
			String pwd = "hr"; //"trng"
			Connection connection=DriverManager.getConnection(URL,uid,pwd);
			return connection;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("Catch"+e.getMessage());
				return null;
			}
		}
		
		

		public boolean isValid(String name,String password)
		{
			boolean b=false;
			Connection cn=mydb_connection();
			try
			{
				PreparedStatement pp=cn.prepareStatement("select * from e_details1 where name=? and password=?");
				pp.setString(1, name);
				pp.setString(2, password);
				ResultSet rs=pp.executeQuery();
				if(rs.next()){
					b=true;
				}else b=false;
				
			
			}catch(Exception e)
			{ e.printStackTrace();
			System.out.println("Catch"+e.getMessage());
			}
			return b; 
		}
		
		
		
		}

