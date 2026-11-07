package com.Fisrst;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Calculator1
 */
@WebServlet("/Calculator1")
public class Calculator1 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Calculator1() {
        super();
      
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
	     String a=request.getParameter("num1");
	     int n1=Integer.parseInt(a);
	     
	     
	     String b=request.getParameter("num2");
            int n2=Integer.parseInt(b);

	
	
	  
	
	String op=request.getParameter("operation");


	switch(op)
	{
	case "add":

		        out.println("Addition of two numbers ="+(n1+n2));
	           break;
	           
	case "sub":

		        out.println("Substraction of two numbers="+(n1-n2));
	            break;
	          
	case "mul":

		out.println("multiplication of tow numbers="+(n1*n2));
               break;
         
	case "div":
	if(n2!=0)
	{

		out.println("Division of two numbers ="+(n1/n2));
	}
	else
	{

		out.println("Cannot divide by Zero");
	}
	           break;
	           
	  default:

		  out.println("Cannot divide by Zero");
	}
	
	
	}

}
