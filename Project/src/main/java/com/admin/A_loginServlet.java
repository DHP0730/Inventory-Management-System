package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;


@WebServlet("/A_loginServlet")
public class A_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//get the parameters passed by adminLogin.jsp
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isTrue;
		
		isTrue = AdminDBUtil.validate(userName, password);
		
		if (isTrue == true) {
			List<Admin> adDetails = AdminDBUtil.getAdmin(userName);
			request.setAttribute("adDetails", adDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("adminHome.jsp");
			dis.forward(request, response);
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='adminLogin.jsp'");
			out.println("</script>");
		}
	}

}

