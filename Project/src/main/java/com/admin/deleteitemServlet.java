package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteitemServlet")
public class deleteitemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderno = request.getParameter("orderno");
		boolean isTrue;
		
		isTrue = AdminDBUtil.deleteitems(orderno);
		
		if (isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Order.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			List<orderitem> itemDetails = AdminDBUtil.getorder(orderno);
			request.setAttribute("itemDetails", itemDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Order.jsp");
			dispatcher.forward(request, response);
		}
	}

}

