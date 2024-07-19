package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;


@WebServlet("/orderservlet")
public class orderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//retrieve ordered item list
			List<orderitem> itemDetails = AdminDBUtil.getitems();
			request.setAttribute("itemDetails", itemDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("Order.jsp");
			dis.forward(request, response);
			
			//get the parameters pass by the updateorder.jsp
			String orderno = request.getParameter("orderno");
			String category = request.getParameter("cat");
			String name = request.getParameter("iname");
			String size = request.getParameter("size");
			String quantity = request.getParameter("qty");
			String supplierid = request.getParameter("supid");
			
			boolean isTrue;
			
			isTrue = AdminDBUtil.updateitem(orderno, category, name, size, quantity, supplierid);
			
			if(isTrue == true) {
				List<orderitem> itDetails = AdminDBUtil.getorder(orderno);
				request.setAttribute("itemDetails", itDetails);
				
				RequestDispatcher disp = request.getRequestDispatcher("Order.jsp");
				disp.forward(request, response);
			
			}
			else {
				List<orderitem> itDetails = AdminDBUtil.getorder(orderno);
				request.setAttribute("itemDetails", itDetails);
				
				RequestDispatcher disp = request.getRequestDispatcher("Order.jsp");
				disp.forward(request, response);
			}
		
	}

}

