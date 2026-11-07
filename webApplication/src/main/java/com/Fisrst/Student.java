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
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		// servlet 
		   response.setContentType("text/html");
		   
		   PrintWriter pw= response.getWriter();
		
		
	        String s1=request.getParameter("id");
                 int id=Integer.parseInt(s1);
    
		    String name=request.getParameter("name");
		     
		    String s3=request.getParameter("age");
		    int age=Integer.parseInt(s3);
		    
		    String email=request.getParameter("email");
		    
		    
		    String number=request.getParameter("number");
		   
		    
//		    pw.println("<h2 style=color:red>Student Details</h2>");
//		    pw.println("<h5>Student Id:</h5>"+id +"<br>");
//		    pw.println("<h5>Student name:</h5>"+name+"<br>");
//		    pw.println("<h5>Student age:</h5>"+age+"<br>");
//		    pw.println("<h5>Student email:</h5>"+email+"<br>");
//		    pw.println("<h5>Student phone:</h5>"+number+"<br>");
		    
		    
		    // connect frontend with database using jdbc connection 
		    
		
		    final String URL="jdbc:mysql://localhost:3306/student_data";
		    final String username="root";
		    final String password="rassu";
		    String query="Insert into student values(?,?,?,?,?)";
		    
		    
		
		       try {
		    	   
		    	  Class.forName("com.mysql.cj.jdbc.Driver");
		    	    // Stage -1
		    	   Connection c=DriverManager.getConnection(URL, username, password);
				
		    	   // Stage-2
		    	   PreparedStatement ps=c.prepareStatement(query);
		    	   ps.setInt(1, id);
		    	   ps.setString(2,name);
		    	   ps.setInt(3, age);
		    	   ps.setString(4,email);
		    	   ps.setString(5,number);
		    	   
		    	   
		    	   //Stage -3
		    	   int e=ps.executeUpdate();
		    	   if(e>0)
		    	   {
			    	   pw.println("Student Registration successfully "); 
		    	   }

		    	   
		    	   // Stage -4
		    	   ps.close();
		    	   c.close();
		    	  } catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				}
		    
		    
		    
		
		
	}

}
