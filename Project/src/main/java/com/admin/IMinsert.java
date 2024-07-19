package com.admin;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;



@WebServlet("/IMinsert")
public class IMinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//get the parameters passed by ManageAccounts.jsp
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("uid");
		String password = request.getParameter("psw");
		
		boolean isTrue;
		
		isTrue = AdminDBUtil.insertIM(name, email, phone, username, password);
		
		

		
		if(isTrue == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Added user successfully');");
			out.println("location='ManageAccounts.jsp'");
			out.println("</script>");
			
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('insertion failed');");
			out.println("location='ManageAccounts.jsp'");
			out.println("</script>");
		}
		
	}
	
	 

}

