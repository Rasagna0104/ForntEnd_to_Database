package com.Fisrst;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Example2
 */
@WebServlet("/Example2")  // Annotation( servlet name )
public class Example2 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Example2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		String num=request.getParameter("number"); // number is used to connect with front to backend action 
		int n=Integer.parseInt(num);
		
		
		if(n%2==0)
		{
//			System.out.println("Even Number..........."); // console 
			out.println("<h3 style=color:green> this  "+n+"  is a Even number </h3>");
		}
		else
		{
//			System.out.println("odd Number.........");\
			out.println("<h3 style=color:green> this "+n+" is  a odd number </h3>");
			
		}
		
	}

}
