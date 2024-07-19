package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createorderServlet")
public class createorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String size = request.getParameter("size");
		String quantity = request.getParameter("qty");
		String supplierid = request.getParameter("supid");
		
		boolean isTrue;
		
		isTrue = AdminDBUtil.insertorder(category, name, size, quantity, supplierid);
		
		if(isTrue == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Added order successfully');");
			out.println("location='Order.jsp'");
			out.println("</script>");
			
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('insertion failed');");
			out.println("location='Order.jsp'");
			out.println("</script>");
		}
	}

}

