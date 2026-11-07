package com.Fisrst;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Example3
 */
@WebServlet("/Example3")
public class Example3 extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Example3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter ps= response.getWriter();
		
		
		String s1=request.getParameter("nums1");
		int n1=Integer.parseInt(s1);
		
		String s2=request.getParameter("nums2");
		int n2=Integer.parseInt(s2);
		
		
		String op=request.getParameter("operation");
		
		switch(op)
		{
		case   "add":
			         ps.println("Addition of two numbers =" +(n1+n2));
			         break;
		case "sub" :
			        ps.println("substrction of two numbers="+(n1-n2));
			        break;
			        
		case "mul":ps.println("Multiplication of two numbers ="+(n1*n2));
		           break;
		
		case "div":
			if(n2!=0)
			{
			     ps.println("Division of two numbers="+(n1/n2));
			}
			else
			{
				ps.println("cannot divide by zero");
			}
		           break;
		
		default:
			       ps.println("Invalid operation");
			      
		}
		
	}

}
