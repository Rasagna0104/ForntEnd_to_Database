package com.Fisrst;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Person
 */
@WebServlet("/Person")
public class Person extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param firstname 
	 * @param lastname 
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
	
		response.setContentType("text/html");
	 PrintWriter out=response.getWriter();
	 
	 
	 
		String s1=request.getParameter("firstname");
		String s2=request.getParameter("lastname");
		
        String s3=request.getParameter("age");
        int age=Integer.parseInt(s3);
        
		String s4=request.getParameter("id");
		int id=Integer.parseInt(s4);
		
		
		String s5=request.getParameter("loc");

		

        
		final String URL="jdbc:mysql://localhost:3306/persondetails";
		final String user="root";
		final String password="rassu";
		String query="Insert into person values(?,?,?,?,?)";
		
		
		
		// Stage -1
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection c=DriverManager.getConnection(URL, user, password);
			
			
			
			// stage-2
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1,s1);
			ps.setString(2, s2);
			ps.setInt(3,age);
			ps.setInt(4, id);
			ps.setString(5, s5);
			
			
			
			// Stage-3
			int result=ps.executeUpdate();
			
			if(result>0)
			{
				out.println("<h5>Registration successfully completed</h5>");
			}
			else
			{
				out.println("<h5> Registration failed</h5>");
			}
			
			
			
			//Stage -5
			ps.close();
			c.close();
		
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
	}

}
