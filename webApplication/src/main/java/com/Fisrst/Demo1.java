package com.Fisrst;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Demo1
 */
@WebServlet("/Demo1")
public class Demo1 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Demo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
     response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String s=request.getParameter("num");
		int n=Integer.parseInt(s);
		if(n%2==0)
		{
//			System.out.println("Even number");
			out.println("<h2 style=color:yellow>This "+n+" is an Even number </h2>");
		}
		else
		{
//			System.out.println("Odd Number");
			out.println("<h3 style=color:blue> This "+n+" is an odd Number </h3>");
			
		}
	}

}
